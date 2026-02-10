package com.practice.problem5.models;

/**
 * Represents a product with ID, name, description, price, category, and stock quantity.
 */
public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private Category category;
    private int stockQuantity;

    /**
     * Creates a new product with the specified details.
     *
     * @param id The unique product ID
     * @param name The name of the product
     * @param description The description of the product
     * @param price The price of the product
     * @param category The category of the product
     * @param stockQuantity The initial stock quantity of the product
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Product(String id, String name, String description, double price, Category category, int stockQuantity) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the product ID.
     *
     * @return the product ID
     */
    public String getId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the product description.
     *
     * @return the product description
     */
    public String getDescription() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the product price.
     *
     * @return the product price
     */
    public double getPrice() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the category of the product.
     *
     * @return the product category
     */
    public Category getCategory() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the current stock quantity of the product.
     *
     * @return the stock quantity
     */
    public int getStockQuantity() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Updates the stock quantity of the product.
     *
     * @param quantityChange The change in quantity (positive to add, negative to subtract)
     */
    public void updateStock(int quantityChange) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if the product is in stock (stock quantity > 0).
     *
     * @return true if the product is in stock, false otherwise
     */
    public boolean isInStock() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if this product is equal to another object.
     * Two products are considered equal if they have the same ID.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the hash code of the product.
     * The hash code is based on the product ID.
     *
     * @return the hash code of the product
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("TODO");
    }
}