class BankAccount{

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        if (initialBalance < 0){
            throw new IllegalArgumentException("initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("amount cannot be negative");
        }
        balance += amount;
    }

    public void withdraw(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("amount cannot be negative");
        }
        if (amount > balance){
            throw new IllegalArgumentException("amount cannot be greater than balance");
        }
        balance -= amount;
    }

}