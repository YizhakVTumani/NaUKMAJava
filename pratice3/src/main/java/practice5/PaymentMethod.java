package practice5;

interface PaymentMethod {
    void name();
    void pay(int amount);
    default void payWithFee(int amount){
        int fee = (amount/100)*10;
        System.out.println("Fee is: " + fee);
    }
}

class CardPayment implements PaymentMethod{
    public void name() {
        System.out.println("name is CardPayment");
    }
    public void pay(int amount){
        System.out.println("amount = " + amount);
    }
}

class PayPalPayment implements PaymentMethod{
    public void name() {
        System.out.println("name is PayPalPayment");
    }
    public void pay(int amount){
        System.out.println("amount = " + amount);
    }
}

class PaymentProcessor{
    private static void process(PaymentMethod meth, int amount){
        meth.name();
        meth.pay(amount);
        meth.payWithFee(amount);
    }

    static void main() {
        PayPalPayment pp = new PayPalPayment();
        CardPayment cp = new CardPayment();
        process(pp, 200);
        process(cp, 300);
    }
}

