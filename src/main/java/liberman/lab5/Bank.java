package liberman.lab5;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> bankAccountList = new ArrayList<>();

    public void createAccount(String accountName, double initialDeposit) {
        try{
            if(initialDeposit < 0){
                throw new NegativeAmountException("Negative initial deposit, please write correctly");
            }
            BankAccount bankAccount = new BankAccount(accountName,initialDeposit);
            bankAccountList.add(bankAccount);
            System.out.println(bankAccount);
        }catch (NegativeAmountException e){
            System.out.println(e);
        }

    }

    public BankAccount findAccount(int accountNumber) {
        try{
            BankAccount bankAccount1 = bankAccountList.stream()
                    .filter(bankAccount -> bankAccount.getAccountNumber() == accountNumber)
                    .findFirst().orElse(null);
            if(bankAccount1 == null) throw new AccountNotFoundException("Account not find");
            return bankAccount1;
        }catch (AccountNotFoundException e){
            System.out.println(e);
        }
        return null;
    }

    public void transferMoney(int fromAccountNumber,int toAccountNumber, double amount) {
        try{
            BankAccount accountSender = findAccount(fromAccountNumber);
            BankAccount accountReceiver = findAccount(toAccountNumber);

            if(amount < 0) throw new NegativeAmountException("Negative amount to send, please write correctly");

            double amountToCheck = accountSender.getBalance() - amount;
            if(amountToCheck < 0) throw new InsufficientFundsException("Not enough to send");

            accountSender.setBalance(amountToCheck);
            accountReceiver.setBalance(accountReceiver.getBalance()+amount);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }
}
