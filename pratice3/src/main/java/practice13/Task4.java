package practice13;

import java.util.concurrent.*;

record SupportTicket(long id, String customer, String topic) {}

class TicketQueue {
    private final BlockingQueue<SupportTicket> queue = new LinkedBlockingQueue<>(10);
    public static final SupportTicket POISON_PILL = new SupportTicket(-1, "asd", "asd");

    public void put(SupportTicket ticket) throws InterruptedException {
        queue.put(ticket);
    }

    public SupportTicket take() throws InterruptedException {
        return queue.take();
    }
}

class TicketProducer implements Runnable {
    private final TicketQueue queue;

    public TicketProducer(TicketQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(new SupportTicket(1, "A", "1"));
            queue.put(new SupportTicket(2, "B", "2"));
            queue.put(new SupportTicket(3, "C", "3"));
            queue.put(new SupportTicket(4, "D", "1"));

            queue.put(TicketQueue.POISON_PILL);
            queue.put(TicketQueue.POISON_PILL);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class TicketConsumer implements Runnable {
    private final TicketQueue queue;
    private final ConcurrentHashMap<String, Integer> stats;

    public TicketConsumer(TicketQueue queue, ConcurrentHashMap<String, Integer> stats) {
        this.queue = queue;
        this.stats = stats;
    }

    @Override
    public void run() {
        try {
            while (true) {
                SupportTicket ticket = queue.take();
                if (ticket == TicketQueue.POISON_PILL) {
                    System.out.println(Thread.currentThread().getName() + " завершує роботу.");
                    break;
                }

                stats.merge(ticket.topic(), 1, Integer::sum);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        TicketQueue queue = new TicketQueue();
        ConcurrentHashMap<String, Integer> stats = new ConcurrentHashMap<>();

        Thread producer = new Thread(new TicketProducer(queue), "Producer");
        Thread consumer1 = new Thread(new TicketConsumer(queue, stats), "Consumer-1");
        Thread consumer2 = new Thread(new TicketConsumer(queue, stats), "Consumer-2");

        producer.start();
        consumer1.start();
        consumer2.start();

        producer.join();
        consumer1.join();
        consumer2.join();

        System.out.println(stats);
    }
}
