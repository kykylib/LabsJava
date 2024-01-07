package liberman.lab5;

public class AccountNotFoundException extends Exception{
    public AccountNotFoundException() {}
    public AccountNotFoundException(String message) {
        super(message);
    }
}
