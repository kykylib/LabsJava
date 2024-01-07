package liberman.lab5;

public class NegativeAmountException extends Exception{
    public NegativeAmountException(){}
    public NegativeAmountException(String message) {
        super(message);
    }
}
