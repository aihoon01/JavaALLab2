package org.exercises.designpatterns.AdapterPattern;

public class Exercise1 {
    public static void main(String[] args) {
        // Instantiate the legacy payment processor
        LegacyPaymentProcessor legacyProcessor = new LegacyPaymentProcessor();

        // Create the adapter to allow the legacy processor to work with the modern gateway interface
        ModernPaymentGateway paymentGateway = new PaymentAdapter(legacyProcessor);

        // Use the modern interface to process a payment
        paymentGateway.makePayment("customer123", 150.00);
    }
}
