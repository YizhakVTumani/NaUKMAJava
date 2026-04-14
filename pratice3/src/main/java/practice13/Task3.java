package practice13;

class Account {
    final int id;
    int balance;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }
}

class TransferService {
    public static void transfer(Account from, Account to, int amount) {
        Account lock1;
        Account lock2;

        if (from.id < to.id) {
            lock1 = from;
            lock2 = to;
        } else {
            lock1 = to;
            lock2 = from;
        }

        synchronized (lock1) {
            try { Thread.sleep(10); } catch (InterruptedException ignored) {}

            synchronized (lock2) {
                if (from.balance >= amount) {
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println(Thread.currentThread().getName() + ": Переказ " + amount + ". Баланс " + from.id + ": " + from.balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + ": Недостатньо коштів.");
                }
            }
        }
    }
}

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 1000);

        Thread t1 = new Thread(() -> TransferService.transfer(acc1, acc2, 500), "1");
        Thread t2 = new Thread(() -> TransferService.transfer(acc2, acc1, 300), "2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Acc1: " + acc1.balance);
        System.out.println("Acc2: " + acc2.balance);
    }
}
