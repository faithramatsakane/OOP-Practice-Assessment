package com.assessment.products;

/**
 * Abstract base class for all products
 */
public abstract class Product {
    // TODO: Declare private fields for id, name, price, and stockQuantity

    /**
     * Constructs a Product object.
     * @param id The product ID.
     * @param name The product name.
     * @param price The unit price of the product.
     * @param stockQuantity The number of units in stock.
     */
    // TODO: Create a constructor that initializes all fields
    public Product(String id, String name, double price, int stockQuantity) {
        // TODO: IMPLEMENT: Initialize fields, calling setters for price and stockQuantity.
    }

    // TODO: Create getters for all fields
    public String getId() { return ""; }
    public String getName() { return ""; }
    public double getPrice() { return 0.0; }
    public int getStockQuantity() { return 0; }

    // TODO: Create setters for price and stockQuantity with validation
    public void setPrice(double price) {
        // TODO: IMPLEMENT: Set price, throwing IllegalArgumentException if price < 0.
    }

    public void setStockQuantity(int stockQuantity) {
        // TODO: IMPLEMENT: Set stockQuantity, throwing IllegalArgumentException if quantity < 0.
    }

    /**
     * Abstract method to calculate the product's discount based on its specific type rules.
     * @return The discount amount in dollars (not percentage).
     */
    public abstract double calculateDiscount();

    /**
     * Calculates the price after applying the discount.
     * @return The final price after discount.
     */
    public double getDiscountedPrice() {
        // TODO: IMPLEMENT: Return the price after subtracting the discount.
        return 0.0;
    }

    @Override
    public String toString() {
        // TODO: IMPLEMENT: Return a formatted string with core product information.
        return "Product Summary";
    }
}