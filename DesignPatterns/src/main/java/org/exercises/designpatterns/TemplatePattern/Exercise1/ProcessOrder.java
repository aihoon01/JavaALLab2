package org.exercises.designpatterns.TemplatePattern.Exercise1;

public class ProcessOrder {
    public static void main(String[] args) {
        System.out.println("Processing Domestic Order:");
        OrderProcessor domesticOrder = new DomesticOrderProcessor();
        domesticOrder.processOrder();

        System.out.println("Processing International Order:");
        OrderProcessor internationalOrder = new InternationalOrderProcessor();
        internationalOrder.processOrder();
    }
}
