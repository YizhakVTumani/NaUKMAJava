package practice7.practice7;

public class Order {
    private int id;
    private String email;
    private int totalCents;

    public Order(int id, String email, int totalCents){
        if(id > 0 && email.contains("@") && totalCents >= 0){
            this.id = id;
            this.email = email;
            this.totalCents = totalCents;
        }
        else {
            throw new IllegalArgumentException("Data is not correct!!!");
        }
    }

    static void main() {
        Order o1 = new Order(123, "gandini@gmail.com", 79);
        Order j2 = new Order(0, "", -19);
    }

}


