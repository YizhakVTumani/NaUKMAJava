package practice11;

import com.sun.net.httpserver.Authenticator;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.StableValue.map;
import static java.util.stream.Collectors.toList;

public class practice11 {
}

class Book{
    private String author;
    private int year;
    List<String> tags ;

    public Book(String author, int year, List<String> tags) {
        this.author = author;
        this.year = year;
        this.tags = tags;
    }

    public List<String> getTags() { return tags; }

    public String getAuthor() {
        return author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }
}

class BookManager{
    static List<Book> books = new ArrayList<>();

    static void bookList(){
        books.add(new Book("Nikolas", 2021, Arrays.asList("a", "kfghk b")));
        books.add(new Book("Andriy", 2021, Arrays.asList("a", "1234 b")));
        books.add(new Book("Mykola", 2015, Arrays.asList("a", "lui b")));
        books.add(new Book("Marichka", 2022, Arrays.asList("d", "df b")));
        books.add(new Book("Sebastian", 2025, Arrays.asList("s", "wqe b")));

        List<String> result = books.stream()
                .filter(x -> x.getYear() >= 2015 )
                .limit(3)
                .map(x -> x.getAuthor())
                .toList();
        List<String> uniqueSortedTags = books.stream()
                .flatMap(b -> b.getTags().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
        System.out.println(uniqueSortedTags);

        Map<String, Long> tagFrequency = books.stream()
                .flatMap(b -> b.getTags().stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        tagFrequency.forEach((k, v) -> System.out.println(k + ": " + v));

        Map<Boolean, List<Book>> recentVsOld = books.stream()
                .collect(Collectors.partitioningBy(b -> b.getYear() > 2015));

        recentVsOld.forEach((k, v) -> System.out.println(k + ": " + v));

    }

    static void main() {
        bookList();
    }
}

class Sale {
    private String product;
    private int revenue;
    private String customerEmail;

    public Sale(String product, int revenue, String customerEmail) {
        this.product = product;
        this.revenue = revenue;
        this.customerEmail = customerEmail;
    }

    public String getProduct() { return product; }
    public int getRevenue() { return revenue; }
    public String getCustomerEmail() { return customerEmail; }
}

class SalesStreamTasks {
    static void main() {
        List<Sale> sales = Arrays.asList(
                new Sale("Laptop", 1500, "user1"),
                new Sale("Mouse", 50, "user2"),
                new Sale("Laptop", 1500, "user1"),
                new Sale("Keyboard", 100, "user3"),
                new Sale("Mouse", 50, "user3")
        );
        Map<String, Integer> revenueByProduct = sales.stream()
                .collect(Collectors.toMap(
                        Sale::getProduct,
                        Sale::getRevenue,
                        Integer::sum
                ));

        revenueByProduct.forEach((product, totalRevenue) ->
                System.out.println(product + " - " + totalRevenue));

        Map<String, Long> transactionsByCustomer = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getCustomerEmail,
                        Collectors.counting()
                ));

        transactionsByCustomer.forEach((email, count) ->
                System.out.println(email + " -> " + count + " транзакцій"));


        Map<String, Integer> revenuee = sales.stream()
                .collect(Collectors.toMap(
                        Sale::getProduct,
                        Sale::getRevenue,
                        Integer::sum,
                        TreeMap::new
                ));

        revenuee.forEach((product, total) ->
                System.out.println(product + " -> " + total));
    }
}

sealed interface Result permits Success, Failure{
 List<Result> res = new ArrayList<>();

    static void main() {
        res.add(new Failure("Erro1"));
        res.add(new Success());
        res.add(new Failure("noterror"));
        res.add(new Failure("new error 1234"));

        List<String> failureMessages = res.stream()
                .filter(Failure.class::isInstance)
                .map(Failure.class::cast)
                .map(Failure::msg)
                .toList();
        failureMessages.forEach(System.out::println);

        Map<Boolean, Long> counts = res.stream()
                .collect(Collectors.partitioningBy(
                        r -> r instanceof Success, // true - Success, false - Failure
                        Collectors.counting()
                ));
        System.out.println("Кількість Success: " + counts.get(true));
        System.out.println("Кількість Failure: " + counts.get(false));
    }
}
record Success() implements Result {

}
record Failure(String msg) implements Result {
 public String getMsg(){ return msg; }
}


