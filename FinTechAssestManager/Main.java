import models.CryptoAsset;
import exceptions.InsufficientFundsException;
import exceptions.InvalidWalletAddressException;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Welcome to Secure Fintech System ---");
        CryptoAsset myCrypto = new CryptoAsset("BTC-01", "My Bitcoin Wallet", 1000.0, 15.0);
        System.out.println("--- Initiating Transfers ---");
        
        try {
            
            myCrypto.transfer("0xABC123", 200.0);
            System.out.println("First transfer successful!");
            myCrypto.transfer("123INVALID", 50.0);
            System.out.println("Second transfer successful!");
        }
        catch (InvalidWalletAddressException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch (InsufficientFundsException e) {
            System.out.println("ERROR: " + e.getMessage() + " Deficit: $" + e.getDeficit());
        }
        System.out.println("\n--- Transaction History ---");
        for(String log : myCrypto.getTransactionHistory()) {
            System.out.println(log);
        }
    }
}
