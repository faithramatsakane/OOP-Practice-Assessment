package com.assessment.payment;

/**
 * Interface for different payment methods
 */
public interface PaymentMethod {
    /**
     * Processes the payment for a given amount.
     * @param amount The total amount to be paid.
     * @return true if the payment was successful, false otherwise.
     */
    boolean processPayment(double amount);

    /**
     * Returns a string containing the details of the payment method.
     * @return The payment details string.
     */
    String getPaymentDetails();
}