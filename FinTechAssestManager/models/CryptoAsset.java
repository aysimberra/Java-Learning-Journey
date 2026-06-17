package models;

import exceptions.InsufficientFundsException;
import exceptions.InvalidWalletAddressException;
import interfaces.Transferable;

public class CryptoAsset extends Asset implements Transferable {
    private double networkFee;
    public CryptoAsset (String assetId, String name, double initialBalance, double networkFee) {
        super(assetId, name, initialBalance);
        this.networkFee = networkFee;
    }
    @Override
    public void transfer(String toWalletAddress, double amount)
            throws InsufficientFundsException, InvalidWalletAddressException {
        if (!toWalletAddress.startsWith("0x")) {
            throw new InvalidWalletAddressException("Invalid wallet address format!");
        }
        double totalCost = amount + networkFee;
        if (balance < totalCost) {
            double deficit = totalCost - balance;
            throw new InsufficientFundsException("Insufficient balance for this transaction.", deficit);
        }
        balance -= totalCost;
        recordTransaction ("Transfer successful: $" + amount + " to " + toWalletAddress + ". Network fee applied: $" + networkFee);
    }
}
