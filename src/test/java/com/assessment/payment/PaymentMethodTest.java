package com.assessment.payment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class PaymentMethodTest {
    @Test
    @DisplayName("Test CreditCardPayment (Polymorphism)")
    public void testCreditCardPayment() {
        PaymentMethod creditCard = new CreditCardPayment("1234567890123456");

        assertTrue(creditCard.processPayment(100.0));
        assertFalse(creditCard.processPayment(0.0));
        assertFalse(creditCard.processPayment(-10.0));

        String details = creditCard.getPaymentDetails();
        assertTrue(details.contains("3456"));
    }

    @Test
    @DisplayName("Test PayPalPayment (Polymorphism)")
    public void testPayPalPayment() {
        PaymentMethod paypal = new PayPalPayment("user@example.com");

        assertTrue(paypal.processPayment(50.0));
        assertFalse(paypal.processPayment(-5.0));

        String details = paypal.getPaymentDetails();
        assertTrue(details.contains("user@example.com"));
    }

    @Test
    @DisplayName("Test CashPayment (Polymorphism)")
    public void testCashPayment() {
        CashPayment cash = new CashPayment(100.0);

        assertTrue(cash.processPayment(80.0));
        assertFalse(cash.processPayment(120.0));

        assertEquals(20.0, cash.getChange(80.0), 0.01);
    }

    @Test
    @DisplayName("Test PaymentMethod polymorphism")
    public void testPaymentPolymorphism() {

        PaymentMethod[] payments = {
                new CreditCardPayment("1111222233334444"),
                new PayPalPayment("buyer@email.com"),
                new CashPayment(200.0)
        };


        for (PaymentMethod payment : payments) {
            assertTrue(payment.processPayment(50.0));
            assertNotNull(payment.getPaymentDetails());
        }
    }
}