# E-Commerce System - Java OOP Assessment

## Time Limit: 2 Hours

## Overview
Build a simplified e-commerce system that manages products, customers, and orders. This assessment focuses on building a clean, structured system by correctly applying core object-oriented concepts.

## Learning Objectives
- Design hierarchical class structures.
- Use interfaces and abstract classes to define contracts.
- Implement polymorphism through method overriding.
- Manage object state safely using access modifiers.
- Use modern Java features like Pattern Matching (Java 21).
- Work with collections and implement complex business logic.

---

## System Requirements

### 1. Product Management
- **Base Structure**: Create an **abstract `Product`** class with common fields (ID, name, price, stock quantity) and the required common methods, including an abstract method for determining discounts.
- **Concrete Subclasses**: Implement the following three classes that build upon the `Product` structure:
    - **ElectronicProduct**: Requires warranty period (months) and brand.
    - **ClothingProduct**: Requires size and material.
    - **BookProduct**: Requires author and number of pages.
- **Data Integrity**: Price and stock quantity must be validated in their respective update methods (must be $\ge 0$).

### 2. Customer & Cart Management
- **`Customer` Class**: Must manage name and email, and **use a provided `ShoppingCart` object**.
- **The `ShoppingCart.java` file is provided and MUST NOT be modified.**
- All methods on the `Customer` (e.g., adding items, getting total) must correctly interact with the internal `ShoppingCart` object.
- **Stock Check**: The method for adding items to the cart must ensure the product has stock $> 0$.

### 3. Payment Processing
- **Interface**: Create a **`PaymentMethod` interface** defining the contract for processing payments and retrieving details.
- **Implementations**: Implement three payment classes adhering to the interface:
    - **CreditCardPayment**: Must hide part of the card number when displaying details.
    - **PayPalPayment**: Uses an email address for details.
    - **CashPayment**: Must include a method, `getChange(double amount)`, to calculate the change due.

### 4. Order Management
- **`Order` Class**:
    - Must manage the associated customer, payment, and a copy of the ordered products.
    - Must generate a unique `orderId` (e.g., using `java.util.UUID`).
    - **Post-Payment Logic**: Upon successful payment, the stock quantity for each product must be reduced by 1, and the customer's cart must be cleared.
    - **Conditional Logic Challenge (Java 21):** The `processOrder()` method must correctly use **Pattern Matching for `instanceof`** to check if the payment method is a `CashPayment` and, if so, calculate and print the change due using its specialized method.

---

## Grading Rubric (100 points)

### I. Class Structure and Contracts (30 points)
- Base abstract Product class correctly defined (10 pts)
- Three concrete product subclasses correctly built (10 pts)
- PaymentMethod interface correctly defined and implemented by payment classes (10 pts)

### II. Code Design and Relationships (35 points)
- **Relationships:** `Customer` correctly uses the provided `ShoppingCart` and correctly delegates all cart functions (15 pts)
- **Conditional Logic Challenge:** `processOrder()` correctly uses **Pattern Matching for `instanceof`** to handle `CashPayment` (10 pts)
- **Behavior:** Methods like discount calculations and payment processing correctly use method overriding and interface definitions (10 pts)

### III. Data Integrity and Functionality (35 points)
- Correct use of private fields, constructors, and getters/setters (15 pts)
- Product setters correctly implement non-negative validation (5 pts)
- All required business logic fully implemented: Discounts, stock check/reduction, change calculation, and successful order processing (15 pts)

---

## Submission Guidelines
1. **Complete all `TODO` comments** in the skeleton code provided.
2. **Ensure all unit tests pass** (the provided test files will be used for grading).
3. **DO NOT MODIFY THE TEST FILES OR `ShoppingCart.java`.**
4. Follow Java naming conventions and adhere to Java 21 features.

## Tips
- Start by declaring your private fields for all classes based on the `TODO` comments.
- Implement the required validation logic in your setters immediately.
- The **Test Files** are the ultimate definition of the required functionality. Use them as your guide.

Good luck!