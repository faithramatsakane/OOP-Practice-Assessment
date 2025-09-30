package com.assessment.customer;

import static org.junit.jupiter.api.Assertions.*;

import com.assessment.products.BookProduct;
import com.assessment.products.ClothingProduct;
import com.assessment.products.ElectronicProduct;
import org.junit.jupiter.api.*;

class CustomerTest {
    @Test
    @DisplayName("Test Customer creation and cart operations")
    public void testCustomerCart() {
        Customer customer = new Customer("Alice Johnson", "alice@email.com");

        assertEquals("Alice Johnson", customer.getName());
        assertEquals("alice@email.com", customer.getEmail());

        ElectronicProduct phone = new ElectronicProduct(
                "E005", "Phone", 500.0, 3, 12, "PhoneBrand"
        );
        BookProduct book = new BookProduct(
                "B004", "Mystery Novel", 20.0, 10, "Author X", 250
        );

        customer.addToCart(phone);
        customer.addToCart(book);


        assertEquals(2, customer.getCart().size());

        customer.removeFromCart(phone);

        assertEquals(1, customer.getCart().size());
    }

    @Test
    @DisplayName("Test Customer cart total calculation")
    public void testCustomerCartTotal() {
        Customer customer = new Customer("Bob Smith", "bob@email.com");

        ElectronicProduct laptop = new ElectronicProduct(
                "E006", "Laptop", 1000.0, 5, 24, "LaptopCo"
        );
        ClothingProduct shirt = new ClothingProduct(
                "C004", "T-Shirt", 25.0, 10, "L", "Cotton"
        );

        customer.addToCart(laptop);
        customer.addToCart(shirt);

        // Expected Calculations (Discount logic is correct, assuming student implementation):
        // Laptop: 1000 * 0.90 = 900.00 (10% off for price > 500)
        // Shirt: 25 * 0.92 = 23.00 (8% off for price <= 100)
        // Total: 923.0
        assertEquals(923.0, customer.getCartTotal(), 0.01);
    }

    @Test
    @DisplayName("Test adding out-of-stock product to cart")
    public void testOutOfStockProduct() {
        Customer customer = new Customer("Charlie Brown", "charlie@email.com");

        ElectronicProduct outOfStock = new ElectronicProduct(
                "E007", "Sold Out Item", 100.0, 0, 12, "Brand"
        );

        customer.addToCart(outOfStock);


        assertEquals(0, customer.getCart().size());
    }
}