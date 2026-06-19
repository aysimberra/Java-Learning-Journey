package exceptions;
public class InsufficientFundsException extends Exception {
    private double deficit;
    public InsufficientFundsException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }
    public double getDeficit() {
        return deficit;
    }
}
