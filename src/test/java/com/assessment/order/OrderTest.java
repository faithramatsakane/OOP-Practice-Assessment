package com.assessment.order;

import static org.junit.jupiter.api.Assertions.*;

import com.assessment.customer.Customer;
import com.assessment.payment.CashPayment;
import com.assessment.payment.CreditCardPayment;
import com.assessment.payment.PayPalPayment;
import com.assessment.payment.PaymentMethod;
import com.assessment.products.BookProduct;
import com.assessment.products.ClothingProduct;
import com.assessment.products.ElectronicProduct;
import org.junit.jupiter.api.*;

class OrderTest {
    @Test
    @DisplayName("Test Order creation and processing")
    public void testOrderProcessing() {
        Customer customer = new Customer("Diana Prince", "diana@email.com");

        ElectronicProduct tablet = new ElectronicProduct(
                "E008", "Tablet", 400.0, 5, 12, "TabletBrand"
        );

        customer.addToCart(tablet);

        PaymentMethod creditCard = new CreditCardPayment("9999888877776666");

        Order order = new Order("ORD001", customer, creditCard);

        assertEquals("ORD001", order.getOrderId());

        // Tablet: 400 * 0.95 = 380.00 (5% off for price <= 500)
        assertEquals(380.0, order.calculateTotal(), 0.01);

        int initialStock = tablet.getStockQuantity();
        boolean success = order.processOrder();

        assertTrue(success);
        assertEquals(initialStock - 1, tablet.getStockQuantity());

        assertEquals(0, customer.getCart().size());
    }

    @Test
    @DisplayName("Test Order with multiple products")
    public void testOrderWithMultipleProducts() {
        Customer customer = new Customer("Eve Adams", "eve@email.com");

        ElectronicProduct phone = new ElectronicProduct(
                "E009", "Smartphone", 600.0, 10, 12, "PhoneCo"
        );
        BookProduct book = new BookProduct(
                "B005", "Tech Guide", 40.0, 20, "Tech Author", 400
        );
        ClothingProduct jacket = new ClothingProduct(
                "C005", "Jacket", 120.0, 15, "M", "Polyester"
        );

        customer.addToCart(phone);
        customer.addToCart(book);
        customer.addToCart(jacket);

        PaymentMethod paypal = new PayPalPayment("eve@email.com");

        Order order = new Order("ORD002", customer, paypal);

        // Expected Calculations:
        // Phone: 600 * 0.90 = 540.00 (10% off for price > 500)
        // Book: 40 * 0.88 = 35.20 (12% off for pages > 300)
        // Jacket: 120 * 0.85 = 102.00 (15% off for price > 100)
        // Total: 677.20
        assertEquals(677.2, order.calculateTotal(), 0.01);

        assertTrue(order.processOrder());
    }

    @Test
    @DisplayName("Test Order with insufficient payment")
    public void testOrderWithInsufficientPayment() {
        Customer customer = new Customer("Frank Miller", "frank@email.com");

        ElectronicProduct expensive = new ElectronicProduct(
                "E010", "Luxury Item", 2000.0, 3, 36, "LuxuryBrand"
        );

        customer.addToCart(expensive);

        // Expected total is 2000 * 0.90 = 1800.00
        PaymentMethod cash = new CashPayment(100.0);

        Order order = new Order("ORD003", customer, cash);

        assertFalse(order.processOrder());


        assertEquals(3, expensive.getStockQuantity());

        assertEquals(1, customer.getCart().getItemCount());
    }

    @Test
    @DisplayName("Test empty order")
    public void testEmptyOrder() {
        Customer customer = new Customer("Grace Lee", "grace@email.com");

        PaymentMethod creditCard = new CreditCardPayment("1234567890123456");

        Order order = new Order("ORD004", customer, creditCard);

        assertEquals(0.0, order.calculateTotal(), 0.01);
        assertFalse(order.processOrder());
    }
}