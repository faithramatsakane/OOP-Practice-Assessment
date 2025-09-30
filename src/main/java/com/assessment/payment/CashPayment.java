package com.assessment.payment;

/**
 * Cash payment implementation of PaymentMethod
 */
public class CashPayment implements PaymentMethod {
    // TODO: Add private field for amountTendered (double)

    // TODO: Create constructor that initializes amountTendered
    public CashPayment(double amountTendered) {
        // TODO: IMPLEMENT: Initialize field and validate amountTendered is not negative.
    }

    /**
     * Calculates the change due.
     * @param amount The required payment amount.
     * @return The change due (amountTendered - amount).
     */
    public double getChange(double amount) {
        // TODO: IMPLEMENT: Return the amount of change due (ensure it's not negative).
        return 0.0;
    }

    @Override
    public boolean processPayment(double amount) {
        // TODO: IMPLEMENT: Return true if amountTendered >= amount
        return false;
    }

    @Override
    public String getPaymentDetails() {
        // TODO: IMPLEMENT: Return a string showing the amount tendered.
        return "Cash Tendered";
    }
}