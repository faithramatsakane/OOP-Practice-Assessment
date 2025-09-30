# E-Commerce System - Java OOP Assessment

## Time Limit: 2 Hours

## Overview
Build a simplified e-commerce system that manages products, customers, and orders. This assessment tests your understanding of Object-Oriented Programming concepts including inheritance, polymorphism, encapsulation, and abstraction.

## Learning Objectives
- Demonstrate inheritance through product hierarchies
- Apply polymorphism with method overriding and interfaces
- Implement encapsulation with proper access modifiers
- Use abstraction through abstract classes and interfaces
- Work with collections and basic business logic

## System Requirements

### 1. Product Management
Create an abstract `Product` class and three concrete product types:
- **ElectronicsProduct**: Has warranty period and brand
- **ClothingProduct**: Has size and material
- **BookProduct**: Has author and number of pages

All products should have:
- ID, name, price, and stock quantity
- Ability to calculate discounts (polymorphic behavior)
- Proper encapsulation of fields

### 2. Customer Management
- Create a `Customer` class with name, email, and shopping cart
- Customers can add/remove products from cart
- Customers can view their cart total

### 3. Payment Processing (Polymorphism Focus)
Create a `PaymentMethod` interface with multiple implementations:
- **CreditCardPayment**: Processes with card number
- **PayPalPayment**: Processes with email
- **CashPayment**: Processes with amount tendered

### 4. Order Management
- Create an `Order` class that ties customer, products, and payment together
- Calculate order total with appropriate discounts
- Process payment using polymorphism

## Grading Rubric (100 points)

### Inheritance (20 points)
- Abstract Product class properly defined (10 pts)
- Three product subclasses correctly extend Product (10 pts)

### Polymorphism (30 points)
- PaymentMethod interface implemented correctly (10 pts)
- Three payment implementations work properly (10 pts)
- Method overriding in product discount calculations (10 pts)

### Encapsulation (20 points)
- Proper use of private fields (10 pts)
- Appropriate getters/setters with validation (10 pts)

### Abstraction (15 points)
- Abstract Product class with abstract methods (8 pts)
- PaymentMethod interface properly defined (7 pts)

### Functionality (15 points)
- All tests pass (10 pts)
- Code compiles without errors (5 pts)

## Submission Guidelines
1. Complete all TODO comments in the skeleton code
2. Ensure all unit tests pass
3. Do not modify test files
4. Follow Java naming conventions
5. Add comments explaining your logic

## Tips
- Start with the abstract classes and interfaces
- Implement one concrete class at a time
- Test frequently as you code
- Pay attention to validation in setters
- Use @Override annotation for clarity

Good luck!