package practice14;

public class CashPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("cash" + amount);
    }
}
