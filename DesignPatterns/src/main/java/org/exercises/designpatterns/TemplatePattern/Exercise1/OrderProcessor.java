package org.exercises.designpatterns.TemplatePattern.Exercise1;

public abstract class OrderProcessor {

    // Template method
    public final void processOrder() {
        selectItem();
        paymentProcessing();
        packaging();
        shipping();
        if (isInternational()) {
            customsClearance();
        }
        generateInvoice();
    }

    // Common steps
    protected void selectItem() {
        System.out.println("Item has been selected.");
    }

    protected void paymentProcessing() {
        System.out.println("Payment has been processed.");
    }

    protected void packaging() {
        System.out.println("Item has been packaged.");
    }

    // Step that subclasses can override
    protected abstract void shipping();

    // Optional step that can be overridden
    protected void customsClearance() {
        System.out.println("Customs clearance has been completed.");
    }

    // Hook method to determine if the order is international
    protected boolean isInternational() {
        return false; // Default implementation; can be overridden in subclasses
    }

    protected void generateInvoice() {
        System.out.println("Invoice has been generated.\n");
    }
}

class DomesticOrderProcessor extends OrderProcessor {

    @Override
    protected void shipping() {
        System.out.println("Shipping within the country.");
    }

    @Override
    protected boolean isInternational() {
        return false; // Confirm this is a domestic order
    }
}

class InternationalOrderProcessor extends OrderProcessor {

    @Override
    protected void shipping() {
        System.out.println("Shipping to an international address.");
    }

    @Override
    protected boolean isInternational() {
        return true; // Confirm this is an international order
    }
}

