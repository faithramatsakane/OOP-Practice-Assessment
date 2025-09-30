package com.assessment.payment;

/**
 * PayPal payment implementation
 */
public class PayPalPayment implements PaymentMethod {
    // TODO: Add private field for email (String)

    // TODO: Create constructor that initializes email
    public PayPalPayment(String email) {
        // TODO: IMPLEMENT: Initialize field and perform basic email format check (e.g., contains '@').
    }

    @Override
    public boolean processPayment(double amount) {
        // TODO: IMPLEMENT: Return true if amount > 0 and email is valid.
        return false;
    }

    @Override
    public String getPaymentDetails() {
        // TODO: IMPLEMENT: Return a string with the PayPal email
        return "PayPal Details";
    }
}