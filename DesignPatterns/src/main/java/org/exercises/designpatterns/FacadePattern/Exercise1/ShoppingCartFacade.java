package org.exercises.designpatterns.FacadePattern.Exercise1;

public class ShoppingCartFacade {
    private Cart cart;
    private DiscountService discountService;
    private PaymentService paymentService;

    public ShoppingCartFacade() {
        cart = new Cart();
        discountService = new DiscountService();
        paymentService = new PaymentService();
    }

    public void addItemToCart(Product product) {
        cart.addItem(product);
    }

    public void checkout() {
        double totalAmount = cart.getTotalPrice();
        System.out.println("Total before discount: $" + totalAmount);

        double discountedAmount = discountService.applyDiscount(totalAmount);
        paymentService.processPayment(discountedAmount);
    }
}

class Main {
    public static void main(String[] args) {
        ShoppingCartFacade shoppingCart = new ShoppingCartFacade();

        // Add products to the cart
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.99);

        shoppingCart.addItemToCart(product1);
        shoppingCart.addItemToCart(product2);

        // Checkout
        shoppingCart.checkout();
    }
}

