package org.exercises.designpatterns.FacadePattern.Exercise1;

import java.util.ArrayList;
import java.util.List;

class PaymentService {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
        // Simulate payment processing
        System.out.println("Payment successful!");
    }
}

class DiscountService {
    public double applyDiscount(double amount) {
        // Apply a 10% discount for demonstration
        double discountRate = 0.10;
        double discount = amount * discountRate;
        System.out.println("Discount applied: $" + discount);
        return amount - discount;
    }
}

class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class LowLevel {
}
