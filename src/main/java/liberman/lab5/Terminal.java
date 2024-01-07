package liberman.lab5;

public class Terminal {
    public static void main(String[] args) throws AccountNotFoundException {
        Bank bank = new Bank();
        bank.createAccount("1",0);
        bank.createAccount("2",10);
        bank.createAccount("3",20);
        bank.createAccount("4",30);
        bank.createAccount("5",40);
        System.out.println("--------------");
        System.out.println(bank.findAccount(1));
        System.out.println(bank.findAccount(2));
        System.out.println(bank.findAccount(3));
        System.out.println(bank.findAccount(4));
        System.out.println(bank.findAccount(5));
        System.out.println("--------------");
        bank.transferMoney(2,1,10);
        System.out.println("--------------");
        System.out.println(bank.findAccount(1));
        System.out.println(bank.findAccount(2));
    }
}

