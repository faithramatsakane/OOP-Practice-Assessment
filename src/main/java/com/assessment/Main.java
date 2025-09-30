package com.assessment;

import com.assessment.customer.Customer;
import com.assessment.order.Order;
import com.assessment.payment.CashPayment;
import com.assessment.payment.CreditCardPayment;
import com.assessment.products.BookProduct;
import com.assessment.products.ClothingProduct;
import com.assessment.products.ElectronicProduct;
import com.assessment.products.Product;

/**
 * Main class to demonstrate the e-commerce system functionality.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("--- E-Commerce System Demonstration ---\n");

        // 1. Setup Products
        Product javaBook = new BookProduct("B101", "Effective Java", 45.99, 5, "Joshua Bloch", 412);
        Product laptop = new ElectronicProduct("E202", "High-End Laptop", 1250.00, 2, 24, "TechCorp");
        Product tShirt = new ClothingProduct("C303", "Cotton T-Shirt", 25.00, 10, "L", "Cotton");

        System.out.println("--- Initial Product States ---");
        System.out.println(javaBook);
        System.out.println(laptop);
        System.out.println(tShirt);

        // 2. Setup Customer and Cart
        Customer alice = new Customer("Alice Smith", "alice.smith@example.com");

        alice.addToCart(javaBook);
        alice.addToCart(laptop);
        alice.addToCart(tShirt);

        System.out.printf("\n%s's Cart Total: $%.2f (Before Checkout)\n", alice.getName(), alice.getCartTotal());

        // 3. Process Order 1: Credit Card
        CreditCardPayment ccPayment = new CreditCardPayment("1234567890123456");
        Order order1 = new Order(alice, ccPayment);
        System.out.println("\n--- Processing Order 1 (Credit Card) ---");
        boolean success1 = order1.processOrder();
        System.out.println("Order 1 Success: " + success1);

        // 4. Process Order 2: Cash Payment (to test change feature and stock update)
        Customer bob = new Customer("Bob Johnson", "bob@example.com");
        bob.addToCart(javaBook);
        bob.addToCart(tShirt);

        // Tender a large amount to ensure change is given
        CashPayment cashPayment = new CashPayment(200.00);
        Order order2 = new Order(bob, cashPayment);
        System.out.println("\n--- Processing Order 2 (Cash Payment) ---");
        boolean success2 = order2.processOrder();
        System.out.println("Order 2 Success: " + success2);
    }
}