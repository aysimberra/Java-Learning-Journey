package interfaces;
import exceptions.InsufficientFundsException;
import exceptions.InvalidWalletAddressException;

public interface Transferable {
    void transfer(String toWalletAddress, double amount) throws InsufficientFundsException, InvalidWalletAddressException;
}
