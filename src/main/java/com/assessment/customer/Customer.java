package com.assessment.customer;

import com.assessment.products.Product;
import com.assessment.order.ShoppingCart;

import java.util.Collections;
import java.util.List;

/**
 * Customer class that now USES a ShoppingCart object for item management.
 */
public class Customer {
    private String name;
    private String  email;
    private ShoppingCart cart;
    // TODO: Add private fields for name (String) , email (String) and cart (ShoppingCart)

    // TODO: Create constructor that initializes name, email, and the ShoppingCart
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.cart = new ShoppingCart();
        // TODO: IMPLEMENT: Initialize name email fields, and cart fields.

    }

    // TODO: Create getters for name and email
    public String getName() {
        return name; }

    public String getEmail() {
        return email; }

    public ShoppingCart getCart() {
        return cart;
    }

    /**
     * Adds a product to the shopping cart via the Cart object.
     * @param product The product to add.
     */
    public void addToCart(Product product) {
        if
//        if (product.getStockQuantity() > 0) {
//            cart.addItem(product);
//        }
        // TODO: IMPLEMENT: Check if product has stock > 0 before adding (using product's method)
        // If in stock, call the cart.addItem(product) method.
    }

    /**
     * Removes a product from the shopping cart.
     * @param product The product to remove.
     */
    public void removeFromCart(Product product) {
        cart.removeItem(product);
        // TODO: IMPLEMENT: Call the cart.removeItem(product) method.
    }

    /**
     * Calculates the total price of all items in the cart using their discounted prices.
     * @return The cart total.
     */
    public double getCartTotal() {
        // TODO: IMPLEMENT: Call the cart.calculateTotal() method.
        return cart.calculateTotal();
    }

    /**
     * Returns an unmodifiable view of the shopping cart's contents.
     * @return A list of products in the cart.
     */
//    public ShoppingCart getCart() {
//        // CHALLENGE: Return the unmodifiable list from the cart object.
//        return new ShoppingCart();
//    }

//    public List<Product> getCart() {
//        return Collections.unmodifiableList(cart.getItems());
//    }


    /**
     * Clears all items from the shopping cart.
     */
    public void clearCart() {
        cart.clear();
        // TODO: IMPLEMENT: Call the cart.clear() method.
    }
}