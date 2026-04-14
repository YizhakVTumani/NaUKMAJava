package practice13;

interface Inventory {
    void reserve(int amount);
    int available();
}

class UnsafeInventory implements Inventory {
    private int items;
    public UnsafeInventory(int items) { this.items = items; }

    @Override
    public void reserve(int amount) {
        if (items >= amount) {
            try { Thread.sleep(1); } catch (InterruptedException ignored) {}
            items -= amount;
        }
    }

    @Override
    public int available() { return items; }
}

class SynchronizedInventory implements Inventory {
    private int items;
    public SynchronizedInventory(int items) { this.items = items; }

    @Override
    public synchronized void reserve(int amount) {
        if (items >= amount) {
            try { Thread.sleep(1); } catch (InterruptedException ignored) {}
            items -= amount;
        }
    }

    @Override
    public synchronized int available() { return items; }
}

class Task2 {
    public static void main(String[] args) throws InterruptedException {
        int iterations = 500;
        int unsafeViolations = 0;
        int safeViolations = 0;

        for (int i = 0; i < iterations; i++) {
            unsafeViolations += runExperiment(new UnsafeInventory(100));
            safeViolations += runExperiment(new SynchronizedInventory(100));
        }

        System.out.println("UnsafeInventory: " + unsafeViolations + " : " + iterations);
        System.out.println("SynchronizedInventory: " + safeViolations + " : " + iterations);
    }

    private static int runExperiment(Inventory inventory) throws InterruptedException {
        Thread t1 = new Thread(() -> inventory.reserve(60));
        Thread t2 = new Thread(() -> inventory.reserve(60));

        t1.start(); t2.start();
        t1.join(); t2.join();

        if (inventory.available() < 0)
            return 1;
        return 0;
    }
}
