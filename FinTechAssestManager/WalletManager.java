import java.util.ArrayList;
import java.util.List;

import exceptions.InsufficientFundsException;
import exceptions.InvalidWalletAddressException;
import interfaces.Transferable;
import models.Asset;

public class WalletManager {
    private List<Asset> portfolio;
    public WalletManager () {
        portfolio = new ArrayList<>();
    }

    public void addAsset(Asset newAsset) {
        portfolio.add(newAsset);
        System.out.println("Asset added to portfolio: " + newAsset.getName());
    }
    public void displayPortfolio() {
        System.out.println("\n--- Current Portfolio ---");

        for (Asset item : portfolio) {
            System.out.println("ID: " + item.getAssetId() + 
                                " | Name: " + item.getName() + 
                                " | Balance/Shares: " + item.getBalance());
        }
        System.out.println("---------------\n");
    }
    public void executeTransfer(String targetAssetId, String toAddress, double amount) {
        for (Asset item : portfolio) {
            if (item.getAssetId().equals(targetAssetId)) {
                System.out.println("Asset found: " + item.getName());
                if (item instanceof Transferable) {
                    Transferable transferableItem = (Transferable) item;

                    try {
                        transferableItem.transfer(toAddress, amount);
                        System.out.println("Transfer completed successfully!");
                    } 
                    catch (InvalidWalletAddressException e) {
                        System.out.println("ERROR: Transfer Failed: " + e.getMessage());
                    } 
                    catch (InsufficientFundsException e) {
                        System.out.println("ERROR: Transfer Failed: " + e.getMessage() + " Missing: $" + e.getDeficit());
                    }
                    
                } else {
                    System.out.println("ERROR: This asset type cannot be transferred!");
                }
                return;
            }
        }
        System.out.println("ERROR: Asset with ID " + targetAssetId + " not found in portfolio!");
    }
}
