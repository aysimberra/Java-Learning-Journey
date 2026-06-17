import models.CryptoAsset;
import models.FiatCurrency;
import models.StockAsset;
import exceptions.InsufficientFundsException;
import exceptions.InvalidWalletAddressException;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Welcome to Secure Fintech System ---");
        
        CryptoAsset myCrypto = new CryptoAsset("BTC-01", "My Bitcoin Wallet", 1000.0, 15.0);
        System.out.println("--- Initiating Transfers ---");

        String[] targetAddresses = {"0xABC123", "123INVALID", "0xXYZ789"};
        double[] transferAmounts = {200.0, 50.0, 5000.0};

        for (int i = 0; i < targetAddresses.length; i++) {
            String address = targetAddresses[i];
            double amount = transferAmounts[i];
        
            try {
                System.out.println("\nProcessing Transaction #" + (i + 1) + " -> Sending $" + amount + " to " + address);
                myCrypto.transfer(address, amount);
                System.out.println("Transaction #" + (i + 1) + " completed successfully!");
            }
            catch (InvalidWalletAddressException e) {
                System.out.println("ERROR: Transaction #" + (i + 1) + " Failed: " + e.getMessage());
            }
            catch (InsufficientFundsException e) {
                System.out.println("ERROR: Transaction #" + (i + 1) + " Failed: " + e.getMessage() + " Missing: $" + e.getDeficit());
            }
        }

        System.out.println("\n--- Initiating Fiat Transfers ---");
        FiatCurrency myBank = new FiatCurrency("TRY-001", "My Salary Account", 2000.0, 5.0);

        String[] fiatAddresses = {"TR123456789", "123INVALID", "TR678906789"};
        double[] fiatAmounts = {500.0, 150.0, 4000.0};

        for (int i = 0; i < fiatAddresses.length; i++) {
            String address = fiatAddresses[i];
            double amount = fiatAmounts[i];
        
            try {
                System.out.println("\nProcessing Fiat Transaction #" + (i + 1) + " -> Sending $" + amount + " to " + address);
                myBank.transfer(address, amount);
                System.out.println("Fiat Transaction #" + (i + 1) + " completed successfully!");
            }
            catch (InvalidWalletAddressException e) {
                System.out.println("ERROR: Fiat Transaction #" + (i + 1) + " Failed: " + e.getMessage());
            }
            catch (InsufficientFundsException e) {
                System.out.println("ERROR: Fiat Transaction #" + (i + 1) + " Failed: " + e.getMessage() + " Missing: $" + e.getDeficit());
            }
        }

        System.out.println("\n--- Transaction History ---");
        for(String log : myCrypto.getTransactionHistory()) {
            System.out.println(log);
        }
        System.out.println("\n--- Fiat Transaction History ---");
         for(String log : myBank.getTransactionHistory()) {
            System.out.println(log);
        }
    }
}
