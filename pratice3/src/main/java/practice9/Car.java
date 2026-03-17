package practice9;

import lombok.Data;
import lombok.Value;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Car {
    private String model;

    public static class Engine{
        int horsepower;
    }

    Engine spec(){
        Engine e1 = new Engine();
        return e1;
    }

}

class Library{
    String name;
    public class Book{
        String title;
        String author;
        String bookLabel(){
            System.out.println();
            return "The lib is: " + name;
        }
    }
}

class Builder{

        String buildIdTicket(String base) {
            class IdBuilder {
                String id;
            }
            return "ID:" + base;
        }

        Runnable runOnce() {
            return null;
        }
}

class TicketBox{
    static List<Ticket> Tickets = new ArrayList<>();
    static void sortByAnon() {
        Ticket t1 = new Ticket(1, "12");
        Tickets.add(t1);
        Ticket t2 = new Ticket(2, "10");
        Tickets.add(t2);
        Tickets.sort(new Comparator<Ticket>() {
            @Override
            public int compare(Ticket a, Ticket b) {
                int byStatus = a.priority - b.priority;
                if (byStatus != 0) return byStatus;
                return a.createdAt.compareTo(b.createdAt);
            }
        });
        System.out.println(Tickets);
    }

    void comparelambda(){
        Comparator<Ticket> byPriority = (o1, o2) -> Integer.compare(o1.priority, o2.priority);
        System.out.println(Tickets);
    }
}

class TicketComp{
    static List<Ticket> Tickets = new ArrayList<>();

    public static class Compar{
        void SortBy2() {
            Ticket t1 = new Ticket(1, "12");
            Tickets.add(t1);
            Ticket t2 = new Ticket(2, "10");
            Tickets.add(t2);
            final int BY_PRIORITY;
            final String BY_CREATED_AT;
            Tickets.sort(
                Comparator.comparing((Ticket t) -> t.priority)
                        .thenComparing((Ticket t) -> t.createdAt)
            );
            System.out.println(Tickets);
        }
    }
}

class Main{
    static void main() {
        TicketBox.sortByAnon();
    }
}

class Ticket{
    String createdAt;
    int priority;
    public Ticket(int priority, String createdAt){
        this.createdAt = createdAt;
        this.priority = priority;
    }
}

@Data
class UserDTO{
    String someData;
}

@Value
final class Price{
    int price;
}

//@Builder
//class CheckoutRequest{
//    String request;
//}


