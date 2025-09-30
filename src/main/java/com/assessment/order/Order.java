package com.assessment.order;

import com.assessment.customer.Customer;
import com.assessment.payment.CashPayment;
import com.assessment.payment.PaymentMethod;
import com.assessment.products.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Order class that ties everything together
 */
public class Order {
    // TODO: Add private fields for orderId (String), customer (Customer),
    // products (List<Product>), and paymentMethod (PaymentMethod)

    /**
     * Constructs an Order object, copying products from the customer's cart.
     */
    public Order(Customer customer, PaymentMethod paymentMethod) {
        // Unique ID Generation: A better way than just a number
        // TODO: IMPLEMENT: Initialize orderId with the UUID structure.
        // TODO: IMPLEMENT: Initialize customer and paymentMethod fields.
        // TODO: IMPLEMENT: Copy products from customer's cart list.
    }

    // TODO: Create getter for orderId
    public String getOrderId() { return ""; }

    /**
     * Calculates the total cost of all products in the order after discount.
     * @return The final order total.
     */
    public double calculateTotal() {
        // TODO: IMPLEMENT: Sum up all discounted product prices from the order list.
        return 0.0;
    }

    /**
     * Executes the payment and updates stock/cart if successful.
     * @return true if the order was successfully processed, false otherwise.
     */
    public boolean processOrder() {
        // TODO: IMPLEMENT STEPS:
        // 1. Check if products list is not empty.
        // 2. Calculate total.
        // 3. Process payment using paymentMethod.processPayment(total).
        // 4. If payment is successful:
        //    a. Reduce stock quantity for each product by 1.
        //    b. Clear the customer's cart.
        //    c. CHALLENGE: Use 'instanceof' and Pattern Matching for 'CashPayment' to calculate and print change.
        // 5. Return success status.
        return false;
    }

    @Override
    public String toString() {
        // TODO: IMPLEMENT: Return a formatted summary of the order.
        return "Order Summary";
    }
}