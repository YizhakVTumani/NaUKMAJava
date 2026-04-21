package practice14;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("card" + amount);
    }
}
