package models;

public class StockAsset extends Asset {
    private String tickerSymbol;
    private double currentPrice;
    
    public StockAsset(String assetID, String name, double initialShares, String tickerSymbol, double currentPrice) {
        super(assetID, name, initialShares);
        this.tickerSymbol = tickerSymbol;
        this.currentPrice = currentPrice;
    }
    public void updatePrice(double newPrice) {
        this.currentPrice = newPrice;
        recordTransaction("Price updated for " + tickerSymbol + ": $" + newPrice);
    }
    public double getTotalValue() {
        double totalValue = balance * currentPrice;
        return totalValue;
    }
}
