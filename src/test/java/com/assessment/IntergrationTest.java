package com.assessment;


import static org.junit.jupiter.api.Assertions.*;
import com.assessment.customer.Customer;
import com.assessment.payment.CashPayment;
import com.assessment.payment.CreditCardPayment;
import com.assessment.payment.PayPalPayment;
import com.assessment.payment.PaymentMethod;
import com.assessment.products.BookProduct;
import com.assessment.products.ClothingProduct;
import com.assessment.products.ElectronicProduct;
import com.assessment.products.Product;
import org.junit.jupiter.api.*;

public class IntergrationTest {
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

        // Laptop: 1500 - 150 (10%) = 1350
        // Shirt: 60 - 4.8 (8%) = 55.2
        // Book: 35 - 4.2 (12%) = 30.8
        // Total: 1436
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
                new ElectronicProduct("E012", "Mouse", 25.0, 50, 6, "MouseCo"),
                new ClothingProduct("C007", "Hat", 20.0, 30, "One Size", "Wool"),
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
}
