package com.assessment;

import static org.junit.jupiter.api.Assertions.*;
import com.assessment.customer.Customer;
import com.assessment.order.Order;
import com.assessment.payment.CashPayment;
import com.assessment.payment.CreditCardPayment;
import com.assessment.payment.PayPalPayment;
import com.assessment.payment.PaymentMethod;
import com.assessment.products.BookProduct;
import com.assessment.products.ClothingProduct;
import com.assessment.products.ElectronicProduct;
import com.assessment.products.Product;
import org.junit.jupiter.api.*;


public class IntegrationTest {
    @Test
    @DisplayName("Integration test: Complete shopping workflow")
    public void testCompleteShoppingWorkflow() {

        Customer customer = new Customer("Henry Ford", "henry@email.com");


        ElectronicProduct laptop = new ElectronicProduct(
                "E011", "Business Laptop", 1500.0, 10, 24, "DellCo"
        );
        ClothingProduct shirt = new ClothingProduct(
                "C006", "Dress Shirt", 60.0, 20, "L", "Cotton"
        );
        BookProduct book = new BookProduct(
                "B006", "Business Strategy", 35.0, 15, "Strategy Expert", 350
        );


        customer.addToCart(laptop);
        customer.addToCart(shirt);
        customer.addToCart(book);


        assertEquals(3, customer.getCart().size());

        // Expected Calculations:
        // Laptop: 1500 * 0.90 = 1350.00
        // Shirt: 60 * 0.92 = 55.20
        // Book: 35 * 0.88 = 30.80
        // Total: 1436.00
        assertEquals(1436.0, customer.getCartTotal(), 0.01);


        PaymentMethod payment = new CreditCardPayment("5555444433332222");

        Order order = new Order("ORD005", customer, payment);


        assertTrue(order.processOrder());



        assertEquals(9, laptop.getStockQuantity());
        assertEquals(19, shirt.getStockQuantity());
        assertEquals(14, book.getStockQuantity());



        assertEquals(0, customer.getCart().size());
    }

    @Test
    @DisplayName("Test polymorphic behavior across all classes")
    public void testPolymorphism() {

        Product[] products = {
                // Discount: 5% (25 * 0.05 = 1.25). Price <= 500
                new ElectronicProduct("E012", "Mouse", 25.0, 50, 6, "MouseCo"),
                // Discount: 8% (20 * 0.08 = 1.60). Price <= 100
                new ClothingProduct("C007", "Hat", 20.0, 30, "One Size", "Wool"),
                // Discount: 5% (18 * 0.05 = 0.90). Pages <= 300
                new BookProduct("B007", "Fiction", 18.0, 40, "Novelist", 280)
        };


        for (Product product : products) {
            double discount = product.calculateDiscount();
            assertTrue(discount >= 0);

            assertTrue(product.getDiscountedPrice() < product.getPrice());
        }


        PaymentMethod[] payments = {
                new CreditCardPayment("1111222233334444"),
                new PayPalPayment("test@test.com"),
                new CashPayment(1000.0)
        };


        for (PaymentMethod payment : payments) {

            assertTrue(payment.processPayment(50.0));
        }
    }
}