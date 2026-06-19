import models.CryptoAsset;
import models.FiatCurrency;
import models.StockAsset;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Welcome to Secure Fintech System ---");
        
        WalletManager manager = new WalletManager();
        System.out.println("\n--- Initializing System ---");

        CryptoAsset btc = new CryptoAsset("BTC-01", "My Bitcoin", 1000.0, 15.0);
        FiatCurrency myBank = new FiatCurrency("TRY-001", "My Salary Account", 2000.0, 5.0);
        StockAsset appleStock = new StockAsset("STK-01", "Apple Shares", 10.0, "AAPL", 150.0);

        manager.addAsset(btc);
        manager.addAsset(myBank);
        manager.addAsset(appleStock);

        manager.displayPortfolio();

        System.out.println("\n--- Executing Transfers ---");
        manager.executeTransfer("BTC-01", "0xABC123", 200.0);
        manager.executeTransfer("TRY-001", "TR123456", 5000.0);
        manager.executeTransfer("STK-01", "0xXYZ890", 5.0);
        manager.executeTransfer("GHOST-99", "TR0000", 100.0);

        System.out.println("\n--- Stock Market Updates ---");
        appleStock.updatePrice(165.0);
        System.out.println("Apple Stock Total Value is now: $" + appleStock.getTotalValue());

        System.out.println("\n--- Transaction History ---");
        System.out.println("Crypto History: ");
        for(String log : btc.getTransactionHistory()) {
            System.out.println("- " + log);
        }
        System.out.println("Stock History: ");
        for(String log : appleStock.getTransactionHistory()) {
            System.out.println("- " + log);
        }
    }
}
