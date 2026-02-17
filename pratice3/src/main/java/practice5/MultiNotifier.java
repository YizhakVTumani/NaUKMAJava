package practice5;

public class MultiNotifier implements SMSNot, EmailNot{

    public void send(){
        SMSNot.super.send();
        EmailNot.super.send();
    }

    void main() {
        send();
    }
}

interface SMSNot{
    default void send(){
        System.out.println("SMS");
    }
}

interface EmailNot{
    default void send(){
        System.out.println("Email");
    }
}
