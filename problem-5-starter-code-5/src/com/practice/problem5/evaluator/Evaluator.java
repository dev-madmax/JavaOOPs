package com.practice.problem5.evaluator;

import com.practice.problem5.models.Product;
import com.practice.problem5.models.Category;
import com.practice.problem5.exceptions.InvalidProductException;
import com.practice.problem5.exceptions.InvalidCategoryException;

public class Evaluator {
    public static void run() {
        // Test basic functionality
        Category electronics = new Category("ELEC", "Electronics");
        Product laptop = new Product("P001", "Laptop", "High-performance laptop", 999.99, electronics, 10);
        
        // Test constructor and getters for Category
        if (!electronics.getId().equals("ELEC")) {
            throw new RuntimeException("Category ID getter failed");
        }
        if (!electronics.getName().equals("Electronics")) {
            throw new RuntimeException("Category name getter failed");
        }
        
        // Test constructor and getters for Product
        if (!laptop.getId().equals("P001")) {
            throw new RuntimeException("Product ID getter failed");
        }
        if (!laptop.getName().equals("Laptop")) {
            throw new RuntimeException("Product name getter failed");
        }
        if (!laptop.getDescription().equals("High-performance laptop")) {
            throw new RuntimeException("Product description getter failed");
        }
        if (laptop.getPrice() != 999.99) {
            throw new RuntimeException("Product price getter failed");
        }
        if (laptop.getStockQuantity() != 10) {
            throw new RuntimeException("Product stock quantity getter failed");
        }
        if (!laptop.getCategory().equals(electronics)) {
            throw new RuntimeException("Product category getter failed");
        }
        
        // Test stock management
        if (!laptop.isInStock()) {
            throw new RuntimeException("Product with positive stock should be in stock");
        }
        
        laptop.updateStock(5);
        if (laptop.getStockQuantity() != 5) {
            throw new RuntimeException("Stock update failed");
        }
        
        laptop.updateStock(-3);
        if (laptop.getStockQuantity() != 2) {
            throw new RuntimeException("Stock reduction failed");
        }
        
        if (!laptop.isInStock()) {
            throw new RuntimeException("Product with stock > 0 should be in stock");
        }
        
        laptop.updateStock(-2);
        if (laptop.getStockQuantity() != 0) {
            throw new RuntimeException("Stock reduction to zero failed");
        }
        
        if (laptop.isInStock()) {
            throw new RuntimeException("Product with zero stock should not be in stock");
        }
        
        // Test invalid product creation
        boolean invalidPriceThrown = false;
        try {
            Product invalidProduct = new Product("P002", "Invalid Price", "Description", -10.0, electronics, 5);
        } catch (IllegalArgumentException e) {
            invalidPriceThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for invalid price: " + e.getMessage());
        }
        if (!invalidPriceThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for negative price");
        }
        
        boolean invalidStockThrown = false;
        try {
            Product invalidProduct = new Product("P003", "Invalid Stock", "Description", 10.0, electronics, -5);
        } catch (IllegalArgumentException e) {
            invalidStockThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for invalid stock: " + e.getMessage());
        }
        if (!invalidStockThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for negative stock");
        }
        
        // Test null values
        boolean nullIdThrown = false;
        try {
            Product nullProduct = new Product(null, "Name", "Description", 10.0, electronics, 5);
        } catch (IllegalArgumentException e) {
            nullIdThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for null ID: " + e.getMessage());
        }
        if (!nullIdThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for null ID");
        }
        
        boolean nullNameThrown = false;
        try {
            Product nullProduct = new Product("P004", null, "Description", 10.0, electronics, 5);
        } catch (IllegalArgumentException e) {
            nullNameThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for null name: " + e.getMessage());
        }
        if (!nullNameThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for null name");
        }
        
        boolean nullDescThrown = false;
        try {
            Product nullProduct = new Product("P005", "Name", null, 10.0, electronics, 5);
        } catch (IllegalArgumentException e) {
            nullDescThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for null description: " + e.getMessage());
        }
        if (!nullDescThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for null description");
        }
        
        boolean nullCategoryThrown = false;
        try {
            Product nullProduct = new Product("P006", "Name", "Description", 10.0, null, 5);
        } catch (IllegalArgumentException e) {
            nullCategoryThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for null category: " + e.getMessage());
        }
        if (!nullCategoryThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for null category");
        }
        
        // Test invalid ID/name
        boolean emptyIdThrown = false;
        try {
            Product emptyProduct = new Product("", "Name", "Description", 10.0, electronics, 5);
        } catch (IllegalArgumentException e) {
            emptyIdThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for empty ID: " + e.getMessage());
        }
        if (!emptyIdThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for empty ID");
        }
        
        boolean emptyNameThrown = false;
        try {
            Product emptyProduct = new Product("P007", "", "Description", 10.0, electronics, 5);
        } catch (IllegalArgumentException e) {
            emptyNameThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for empty name: " + e.getMessage());
        }
        if (!emptyNameThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for empty name");
        }
        
        // Test equals/hashCode for Product
        Product product1 = new Product("PRD100", "Product 1", "Description 1", 25.99, electronics, 8);
        Product product2 = new Product("PRD100", "Product 2", "Description 2", 30.99, electronics, 10);  // Same ID, different other fields
        Product product3 = new Product("PRD200", "Product 1", "Description 1", 25.99, electronics, 8);  // Different ID, same other fields
        
        if (!product1.equals(product2)) {
            throw new RuntimeException("Products with same ID should be equal");
        }
        if (product1.equals(product3)) {
            throw new RuntimeException("Products with different IDs should not be equal");
        }
        if (product1.hashCode() != product2.hashCode()) {
            throw new RuntimeException("Equal products should have same hash code");
        }
        
        // Test equals/hashCode for Category
        Category category1 = new Category("CAT1", "Category 1");
        Category category2 = new Category("CAT1", "Category 2");  // Same ID, different name
        Category category3 = new Category("CAT2", "Category 1");  // Different ID, same name
        
        if (!category1.equals(category2)) {
            throw new RuntimeException("Categories with same ID should be equal");
        }
        if (category1.equals(category3)) {
            throw new RuntimeException("Categories with different IDs should not be equal");
        }
        if (category1.hashCode() != category2.hashCode()) {
            throw new RuntimeException("Equal categories should have same hash code");
        }
        
        // Test stock update with invalid values
        Product stockTestProduct = new Product("P008", "Stock Test", "Testing stock updates", 15.50, electronics, 5);
        
        // Test negative stock update that would result in negative quantity
        // This should be allowed as it just reduces the stock
        stockTestProduct.updateStock(-10);  // This should result in -5, which might be valid in some systems
        // Actually, let's test that we can go negative (if allowed by implementation)
        // Or if implementation prevents going negative, we need to check that behavior
        
        // Test large quantities and prices
        Product largeProduct = new Product("P999", "Large Product", "Very expensive item", 999999.99, electronics, 10000);
        if (largeProduct.getPrice() != 999999.99 || largeProduct.getStockQuantity() != 10000) {
            throw new RuntimeException("Large values not handled correctly");
        }
        
        // Test stock availability
        Product availableProduct = new Product("P009", "Available", "Item in stock", 20.0, electronics, 1);
        if (!availableProduct.isInStock()) {
            throw new RuntimeException("Product with 1 in stock should be in stock");
        }
        
        availableProduct.updateStock(-1);
        if (availableProduct.isInStock()) {
            throw new RuntimeException("Product with 0 in stock should not be in stock");
        }
        
        System.out.println("PASS");
    }
}