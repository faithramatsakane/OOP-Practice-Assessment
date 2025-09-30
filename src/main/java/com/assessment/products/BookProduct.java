package com.assessment.products;

/**
 * Concrete product class for books
 */
public class BookProduct extends Product {
    // TODO: Add private fields for author (String) and numberOfPages (int)

    /**
     * Constructs a BookProduct object.
     */
    public BookProduct(String id, String name, double price, int stockQuantity, String author, int numberOfPages) {
        super(id, name, price, stockQuantity);
        // TODO: IMPLEMENT: Initialize book-specific fields.
    }

    // TODO: Create getters for author and numberOfPages
    public String getAuthor() { return ""; }
    public int getNumberOfPages() { return 0; }

    @Override
    public double calculateDiscount() {
        // TODO: IMPLEMENT: Books get 12% discount if numberOfPages > 300, otherwise 5%.
        return 0.0;
    }

    @Override
    public String toString() {
        // TODO: IMPLEMENT: Call super.toString() and append author and page details.
        return super.toString();
    }
}