package models;
import exceptions.InsufficientFundsException;
import exceptions.InvalidWalletAddressException;
import interfaces.Transferable;

public class FiatCurrency extends Asset implements Transferable {
    private double eftFee;
    public FiatCurrency(String assetID, String name, double initialBalance, double eftFee) {
        super(assetID, name, initialBalance);
        this.eftFee = eftFee;
    }

    @Override
    public void transfer(String toWalletAddress, double amount)
            throws InsufficientFundsException, InvalidWalletAddressException {
        if (!toWalletAddress.startsWith("TR")) {
            throw new InvalidWalletAddressException("Invalid IBAN format!");
        }
        double totalCost = amount + eftFee;
        if (balance < totalCost) {
            double deficit = totalCost - balance;
            throw new InsufficientFundsException("Insufficient balance for this transaction.", deficit);
        }
        balance -= totalCost;
        recordTransaction ("EFT successful: $" + amount + " to IBAN " + toWalletAddress + ". EFT fee applied: $" + eftFee);
    }
}
