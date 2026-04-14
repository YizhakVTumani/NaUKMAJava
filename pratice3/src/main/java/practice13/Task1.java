package practice13;

import java.util.List;

record Order(long id, int totalCents) {}

class TaskRunner {
    public static void runAndWait(List<Runnable> tasks) {
        List<Thread> threads = tasks.stream()
                .map(Thread::new)
                .toList();
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Потік було перервано");
            }
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, 150),
                new Order(2, 450),
                new Order(3, 200)
        );

        final long[] totalSum = {0};
        final int[] maxOrder = {0};

        Runnable sumTask = () -> {
            totalSum[0] = orders.stream().mapToLong(Order::totalCents).sum();
        };

        Runnable maxTask = () -> {
            maxOrder[0] = orders.stream().mapToInt(Order::totalCents).max().orElse(0);
        };

        TaskRunner.runAndWait(List.of(sumTask, maxTask));

        System.out.println("Сума: " + totalSum[0]);
        System.out.println("Макс: " + maxOrder[0]);
    }
}