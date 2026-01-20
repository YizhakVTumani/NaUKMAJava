public class Main {

    static void main() {
        BankAccount account1 = new BankAccount("000109", 200);
        account1.deposit(500);
        account1.withdraw(100);
        account1.deposit(-500);
        account1.withdraw(1000);
        BankAccount account2 = new BankAccount("000108", -200);

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
    }


}