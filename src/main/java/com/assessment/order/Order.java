package com.assessment.order;

/**
 * Order class that ties everything together (Composition)
 */
class Order {
    // TODO: Add private fields for orderId (String), customer (Customer),
    // products (ArrayList<Product>), and paymentMethod (PaymentMethod)

    // TODO: Create constructor that initializes all fields
    // Copy products from customer's cart

    // TODO: Create getter for orderId

    // TODO: Create method calculateTotal() that returns double
    // Sum up all discounted product prices

    // TODO: Create method processOrder() that returns boolean
    // 1. Check if products list is not empty
    // 2. Calculate total
    // 3. Process payment using the paymentMethod (Polymorphism in action!)
    // 4. If successful, reduce stock for each product and clear customer's cart
    // 5. Return success status

    // TODO: Override toString() to display order summary
}