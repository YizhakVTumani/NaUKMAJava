package practice12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static practice12.Main.PathSafety.safeResolve;
import static practice12.Main.StatusFile.readStatus;
import static practice12.Main.StatusFile.updateStatus;

enum PaymentStatus {
        NEW, PAID, FAILED;
    }

    public record Payment(String id, String email, PaymentStatus status, int amountCents) {}

    record PaymentResult(List<Payment> payments, int invalidLines) {}

    class PaymentReportWriter{

            public static void writeReport(Path out, List<Payment> payments, int invalidLines) {
                long paidTotalCents = 0;
                int countNew = 0;
                int countPaid = 0;
                int countFailed = 0;

                for (Payment p : payments) {
                    switch (p.status()) {
                        case NEW -> countNew++;
                        case PAID -> {
                            countPaid++;
                            paidTotalCents += p.amountCents();
                        }
                        case FAILED -> countFailed++;
                    }
                }

                Path tempFile = out.resolveSibling(out.getFileName() + ".tmp");

                try {
                    try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
                        writer.write("invalidLines=" + invalidLines);
                        writer.newLine();

                        writer.write("paidTotalCents=" + paidTotalCents);
                        writer.newLine();

                        writer.write("NEW=" + countNew + ", PAID=" + countPaid + ", FAILED=" + countFailed);
                        writer.newLine();
                    }

                    Files.move(tempFile, out,
                            StandardCopyOption.REPLACE_EXISTING,
                            StandardCopyOption.ATOMIC_MOVE);


                } catch (IOException e) {
                    System.err.println(e.getMessage());

                    try {
                        Files.deleteIfExists(tempFile);
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
    }

 class PaymentLoader {

    public static PaymentResult loadWithStats(Path csvPath) {
        List<Payment> payments = new ArrayList<>();
        int invalidLines = 0;

        try (BufferedReader reader = Files.newBufferedReader(csvPath)) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                Payment payment = parseLine(line);
                if (payment != null) {
                    payments.add(payment);
                } else {
                    invalidLines++;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return new PaymentResult(payments, invalidLines);
    }

    private static Payment parseLine(String line) {
        String[] parts = line.split(",");

        if (parts.length != 4) return null;

        try {
            String id = parts[0].trim();
            String email = parts[1].trim();
            PaymentStatus status;
            try {
                status = PaymentStatus.valueOf(parts[2].trim());
            }catch(IllegalArgumentException e){
                status = null;
            }
            int amount = Integer.parseInt(parts[3].trim());

            if (status == null || id.isEmpty() || email.isEmpty()) {
                return null;
            }

            return new Payment(id, email, status, amount);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

class InboxArchiver {

    public static void archiveTmpFiles(Path inbox, Path archive) {
        try {
            if (Files.notExists(archive)) {
                Files.createDirectories(archive);
            }

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(inbox, "*.tmp")) {
                int movedCount = 0;

                for (Path file : stream) {
                    Path targetPath = archive.resolve(file.getFileName());

                    Files.move(file, targetPath, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Архівовано: " + file.getFileName());
                    movedCount++;
                }

                System.out.println("Усього переміщено файлів: " + movedCount);
            }

        } catch (DirectoryIteratorException | IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

class Main {
    static void main(String[] args) {
        Path statusFile = Paths.get("status.bin");
        int N = 10;
        Path inboxDir = Paths.get("practical-data/inbox");
        Path archiveDir = Paths.get("practical-data/archive");
        Path path = Paths.get("payment.csv");
        Path baseDir = Paths.get("user_data");


        PaymentResult result = PaymentLoader.loadWithStats(path);

        System.out.println("Валідних платежів: " + result.payments().size());
        System.out.println("Відкинуто рядків:  " + result.invalidLines());

        if (!result.payments().isEmpty()) {
            System.out.println(result.payments().get(0));
        }

        try {
            Files.createDirectories(inboxDir);

            Files.writeString(inboxDir.resolve("payment_101.tmp"), "Тимчасовий файл 1");
            Files.writeString(inboxDir.resolve("payment_102.tmp"), "Тимчасовий файл 2");
            Files.writeString(inboxDir.resolve("readme.txt"), "Текстовий файл");
            Files.writeString(inboxDir.resolve("summary.txt"), "Звіт");

            InboxArchiver.archiveTmpFiles(inboxDir, archiveDir);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {
            Path safeFile = safeResolve(baseDir, "reports/2025.txt");
            System.out.println("Успіх: " + safeFile);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }

        try {
            Path unsafeFile = safeResolve(baseDir, "../secret.txt");
            System.out.println("Успіх: " + unsafeFile);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка:: " + e.getMessage());
        }

        try {
            byte[] initialData = new byte[N];
            Files.write(statusFile, initialData);

            long targetIndex = 4;
            byte newStatus = 7;
            updateStatus(statusFile, targetIndex, newStatus);

            byte readBack = readStatus(statusFile, targetIndex);

            if (readBack == newStatus) {
                System.out.println("Тест успішний");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try { Files.deleteIfExists(statusFile); } catch (IOException ignored) {}
        }


        PaymentResult res = PaymentLoader.loadWithStats(path);
        Path reportPath = Paths.get("report.txt");
        PaymentReportWriter.writeReport(reportPath, res.payments(), res.invalidLines());
    }

    class PathSafety {

        public static Path safeResolve(Path base, String userInput) {
            Path absoluteBase = base.toAbsolutePath().normalize();

            Path resolvedPath = base.resolve(userInput).toAbsolutePath().normalize();

            if (!resolvedPath.startsWith(absoluteBase)) {
                throw new IllegalArgumentException("Помилка безпеки: (" + userInput + ")");
            }

            return resolvedPath;
        }
    }

    public class StatusFile {
        public static void updateStatus(Path file, long index, byte status) throws IOException {
            try (RandomAccessFile raf = new RandomAccessFile(file.toFile(), "rw");
                 FileChannel channel = raf.getChannel()) {

                channel.position(index);

                ByteBuffer buffer = ByteBuffer.allocate(1);
                buffer.put(status);
                buffer.flip();

                channel.write(buffer);
            }
        }

        public static byte readStatus(Path file, long index) throws IOException {
            try (RandomAccessFile raf = new RandomAccessFile(file.toFile(), "r");
                 FileChannel channel = raf.getChannel()) {

                channel.position(index);
                ByteBuffer buffer = ByteBuffer.allocate(1);
                int bytesRead = channel.read(buffer);

                if (bytesRead <= 0) {
                    throw new IOException("Кінець файлу");
                }

                buffer.flip();
                return buffer.get();
            }
        }
    }
}