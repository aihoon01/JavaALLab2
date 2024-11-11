package org.exercises.designpatterns.ObserverPattern.Exercise2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface Subject {
    void addObserver(String stockSymbol, Observer observer);
    void removeObserver(String stockSymbol, Observer observer);
    void notifyObservers(String stockSymbol, float newPrice);
}

class StockMarket implements Subject {
    // Map to hold stock prices
    private Map<String, Float> stockPrices;

    // Map of stock symbols to lists of observers
    private Map<String, List<Observer>> observers;

    public StockMarket() {
        stockPrices = new HashMap<>();
        observers = new HashMap<>();
    }

    @Override
    public void addObserver(String stockSymbol, Observer observer) {
        observers.computeIfAbsent(stockSymbol, k -> new ArrayList<>()).add(observer);
    }

    @Override
    public void removeObserver(String stockSymbol, Observer observer) {
        List<Observer> stockObservers = observers.get(stockSymbol);
        if (stockObservers != null) {
            stockObservers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(String stockSymbol, float newPrice) {
        List<Observer> stockObservers = observers.get(stockSymbol);
        if (stockObservers != null) {
            for (Observer observer : stockObservers) {
                observer.update(stockSymbol, newPrice);
            }
        }
    }

    // Method to update stock price and notify observers
    public void setStockPrice(String stockSymbol, float newPrice) {
        stockPrices.put(stockSymbol, newPrice);
        System.out.println("StockMarket: Price updated for " + stockSymbol + " to $" + newPrice);
        notifyObservers(stockSymbol, newPrice);
    }
}

