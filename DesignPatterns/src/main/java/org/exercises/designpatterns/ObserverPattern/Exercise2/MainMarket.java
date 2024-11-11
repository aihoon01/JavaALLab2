package org.exercises.designpatterns.ObserverPattern.Exercise2;

public class MainMarket {
    public static void main(String[] args) {
        // Create a StockMarket
        StockMarket stockMarket = new StockMarket();

        // Create users (observers)
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        // Users subscribe to specific stocks
        stockMarket.addObserver("AAPL", user1);
        stockMarket.addObserver("AAPL", user2);
        stockMarket.addObserver("GOOGL", user2);
        stockMarket.addObserver("TSLA", user3);

        // Simulate stock price updates
        System.out.println("Setting stock prices...");
        stockMarket.setStockPrice("AAPL", 150.0f);
        stockMarket.setStockPrice("GOOGL", 2800.0f);
        stockMarket.setStockPrice("TSLA", 700.0f);

        // Unsubscribe a user and update stock price again
        stockMarket.removeObserver("AAPL", user2);
        System.out.println("\nAfter unsubscribing Bob from AAPL:");
        stockMarket.setStockPrice("AAPL", 155.0f);
    }
}
