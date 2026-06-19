package exceptions;
public class InvalidWalletAddressException extends Exception {
    public InvalidWalletAddressException(String message) {
        super(message);
    }
}
