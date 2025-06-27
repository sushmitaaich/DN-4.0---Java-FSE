public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mobileApp = new MobileApp();
        market.registerObserver(mobileApp);

        market.setStockPrice("XYZ", 101.5);
    }
}
