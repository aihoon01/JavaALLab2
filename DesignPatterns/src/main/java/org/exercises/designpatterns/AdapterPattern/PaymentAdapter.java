package org.exercises.designpatterns.AdapterPattern;

public class PaymentAdapter implements ModernPaymentGateway{

    private final LegacyPaymentProcessor legacyProcessor;

    // Constructor to initialize the legacy payment processor
    public PaymentAdapter(LegacyPaymentProcessor legacyProcessor) {
        this.legacyProcessor = legacyProcessor;
    }

    @Override
    public void makePayment(String customerId, double amount) {
        // Assume `customerId` is used as the `accountNumber` in the legacy system
        legacyProcessor.processPayment(customerId, amount);
    }
}

class LegacyPaymentProcessor {
    public void processPayment(String accountNumber, double amount) {
        System.out.println("Processing payment of $" + amount + " to account " + accountNumber + " using LegacyPaymentProcessor");
    }
}


interface ModernPaymentGateway {
    void makePayment(String customerId, double amount);
}