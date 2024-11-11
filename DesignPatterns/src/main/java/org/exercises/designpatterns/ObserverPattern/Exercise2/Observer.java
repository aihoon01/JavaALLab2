package org.exercises.designpatterns.ObserverPattern.Exercise2;

public interface Observer {
    void update(String stockSymbol, float newPrice);
}

class User implements Observer {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(String stockSymbol, float newPrice) {
        System.out.println("User " + username + " notified: " + stockSymbol + " is now $" + newPrice);
    }
}
