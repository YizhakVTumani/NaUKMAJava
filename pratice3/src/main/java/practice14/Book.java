package practice14;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Book{
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

class ClassInfoPrinter {
    public static void print(Class<?> clazz) {
        System.out.println("class Name " + clazz.getName());

        System.out.println("superclass " + (clazz.getSuperclass() != null ? clazz.getSuperclass().getName() : "None"));

        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println("interfaces " + (interfaces.length > 0 ? Arrays.toString(interfaces) : "None"));

        System.out.println("fields");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(" - " + field.getType().getSimpleName() + " " + field.getName());
        }

        System.out.println("methods");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(" - " + method.getReturnType().getSimpleName() + " " + method.getName());
        }
    }
}


class PracticeMain {
    public static void main(String[] args) {
        ClassInfoPrinter.print(Book.class);


        PaymentService cardService = (PaymentService) ServiceFactory.create("practice14.CardPaymentService");
        cardService.pay(250.75);

        PaymentService cashService = (PaymentService) ServiceFactory.create("practice14.CashPaymentService");
        cashService.pay(100.00);


        SetupFlow setupFlow = new SetupFlow();
        try {
            StepRunner.run(setupFlow);
        } catch (StepExecutionException e) {
            System.err.println("Caught StepExecutionException: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Original Cause: " + e.getCause().getClass().getSimpleName() + " - " + e.getCause().getMessage());
            }
        }
    }
}
