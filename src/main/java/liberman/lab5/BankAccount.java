package liberman.lab5;

public class BankAccount {
    private static int numberForAcc = 1;
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(String accountName, double balance) {
        this.accountNumber = numberForAcc++;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount>0) balance += amount;
    }

    public void withdraw(double amount){
        if(amount < balance){
            balance -= amount;
            return;
        }
        System.out.println("Not enough money to withdraw");
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
