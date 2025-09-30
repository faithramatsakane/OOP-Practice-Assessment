package com.assessment.products;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Comprehensive test suite for E-Commerce System
 * DO NOT MODIFY THIS FILE
 */
public class ProductTest {


    @Test
    @DisplayName("Test ElectronicsProduct creation and encapsulation")
    public void testElectronicsProductCreation() {
        ElectronicProduct laptop = new ElectronicProduct(
                "E001", "Gaming Laptop", 1200.0, 10, 24, "TechBrand"
        );

        assertEquals("E001", laptop.getId());
        assertEquals("Gaming Laptop", laptop.getName());
        assertEquals(1200.0, laptop.getPrice());
        assertEquals(10, laptop.getStockQuantity());
        assertEquals(24, laptop.getWarrantyPeriod());
        assertEquals("TechBrand", laptop.getBrand());
    }

    @Test
    @DisplayName("Test ElectronicsProduct discount calculation (Polymorphism)")
    public void testElectronicsDiscount() {
        ElectronicProduct expensivePhone = new ElectronicProduct(
                "E002", "Smartphone", 800.0, 5, 12, "PhoneCorp"
        );
        ElectronicProduct cheapPhone = new ElectronicProduct(
                "E003", "Basic Phone", 200.0, 15, 6, "BudgetBrand"
        );


        assertEquals(80.0, expensivePhone.calculateDiscount(), 0.01);
        assertEquals(720.0, expensivePhone.getDiscountedPrice(), 0.01);


        assertEquals(10.0, cheapPhone.calculateDiscount(), 0.01);
        assertEquals(190.0, cheapPhone.getDiscountedPrice(), 0.01);
    }

    @Test
    @DisplayName("Test ClothingProduct creation and encapsulation")
    public void testClothingProductCreation() {
        ClothingProduct shirt = new ClothingProduct(
                "C001", "Cotton Shirt", 45.0, 20, "M", "Cotton"
        );

        assertEquals("C001", shirt.getId());
        assertEquals("Cotton Shirt", shirt.getName());
        assertEquals("M", shirt.getSize());
        assertEquals("Cotton", shirt.getMaterial());
    }

    @Test
    @DisplayName("Test ClothingProduct discount calculation (Polymorphism)")
    public void testClothingDiscount() {
        ClothingProduct jacket = new ClothingProduct(
                "C002", "Winter Jacket", 150.0, 8, "L", "Wool"
        );
        ClothingProduct socks = new ClothingProduct(
                "C003", "Socks", 10.0, 50, "One Size", "Cotton"
        );


        assertEquals(22.5, jacket.calculateDiscount(), 0.01);
        assertEquals(127.5, jacket.getDiscountedPrice(), 0.01);


        assertEquals(0.8, socks.calculateDiscount(), 0.01);
        assertEquals(9.2, socks.getDiscountedPrice(), 0.01);
    }

    @Test
    @DisplayName("Test BookProduct creation and encapsulation")
    public void testBookProductCreation() {
        BookProduct book = new BookProduct(
                "B001", "Java Programming", 55.0, 15, "John Doe", 450
        );

        assertEquals("B001", book.getId());
        assertEquals("Java Programming", book.getName());
        assertEquals("John Doe", book.getAuthor());
        assertEquals(450, book.getNumberOfPages());
    }

    @Test
    @DisplayName("Test BookProduct discount calculation (Polymorphism)")
    public void testBookDiscount() {
        BookProduct longBook = new BookProduct(
                "B002", "Epic Novel", 30.0, 10, "Jane Smith", 500
        );
        BookProduct shortBook = new BookProduct(
                "B003", "Quick Read", 15.0, 25, "Bob Brown", 150
        );

        assertEquals(3.6, longBook.calculateDiscount(), 0.01);
        assertEquals(26.4, longBook.getDiscountedPrice(), 0.01);


        assertEquals(0.75, shortBook.calculateDiscount(), 0.01);
        assertEquals(14.25, shortBook.getDiscountedPrice(), 0.01);
    }

    @Test
    @DisplayName("Test Product setters with validation (Encapsulation)")
    public void testProductSetters() {
        ElectronicProduct product = new ElectronicProduct(
                "E004", "Tablet", 300.0, 5, 12, "TabletCo"
        );


        product.setPrice(350.0);
        assertEquals(350.0, product.getPrice());

        product.setStockQuantity(10);
        assertEquals(10, product.getStockQuantity());

        product.setPrice(-50.0);
        assertEquals(350.0, product.getPrice());

        product.setStockQuantity(-5);
        assertEquals(10, product.getStockQuantity());
    }
}