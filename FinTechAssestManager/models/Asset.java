package models;
import java.util.List;
import interfaces.Auditable;
import java.util.ArrayList;

public abstract class Asset implements Auditable {
    private String assetId;
    private String name;
    protected double balance;
    private List <String> transactionHistory;

    public Asset (String assetId, String name, double initialBalance) {
        this.assetId = assetId;
        this.name = name;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();

        recordTransaction("Asset created with initial balance: " + initialBalance);
    }


    @Override
    public void recordTransaction(String transactionDetails) {
        String logEntry = transactionDetails;
        transactionHistory.add(logEntry);
    }

    public String getAssetId() {
        return assetId;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
