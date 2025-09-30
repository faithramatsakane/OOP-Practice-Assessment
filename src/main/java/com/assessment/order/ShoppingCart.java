package com.assessment.order;

import com.assessment.products.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Cart object to manage the collection of products.
 * DO NOT MODIFY THIS.
 */
public final class ShoppingCart {
    private final List<Product> items;

    /**
     * Constructs an empty ShoppingCart.
     */
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a product to the cart.
     * Note: Stock check should be done by the calling Customer method.
     */
    public void addItem(Product product) {
        if (product != null) {
            items.add(product);
            System.out.println(product.getName() + " added to cart.");
        }
    }

    /**
     * Removes a product from the cart.
     */
    public void removeItem(Product product) {
        if (product != null && items.remove(product)) {
            System.out.println(product.getName() + " removed from cart.");
        } else if (product != null) {
            System.out.println("Error: " + product.getName() + " not found in cart.");
        }
    }

    /**
     * Calculates the total price of all items using their discounted prices.
     */
    public double calculateTotal() {
        double total = 0.0;
        for (Product product : items) {
            total += product.getDiscountedPrice();
        }
        return total;
    }

    /**
     * Clears all items from the cart.
     */
    public void clear() {
        items.clear();
        System.out.println("Shopping cart cleared.");
    }

    /**
     * Returns an unmodifiable view of the cart contents.
     * @return The immutable list of items.
     */
    public List<Product> getCartItems() {
        return Collections.unmodifiableList(items);
    }

    public int size() {
        return items.size();
    }
}