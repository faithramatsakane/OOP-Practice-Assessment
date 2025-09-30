package com.assessment.products;

/**
 * Concrete product class for electronics
 */
public class ElectronicProduct extends Product {
    // TODO: Add private fields for warrantyPeriod (int, in months) and brand (String)

    /**
     * Constructs an ElectronicProduct object.
     */
    public ElectronicProduct(String id, String name, double price, int stockQuantity, int warrantyPeriod, String brand) {
        super(id, name, price, stockQuantity);
        // TODO: IMPLEMENT: Initialize electronics-specific fields.
    }

    // TODO: Create getters for warrantyPeriod and brand
    public int getWarrantyPeriod() { return 0; }
    public String getBrand() { return ""; }

    @Override
    public double calculateDiscount() {
        // TODO: IMPLEMENT: Electronics get 10% discount if price > 500, otherwise 5%.
        return 0.0;
    }

    @Override
    public String toString() {
        // TODO: IMPLEMENT: Call super.toString() and append brand and warranty details.
        return super.toString();
    }
}