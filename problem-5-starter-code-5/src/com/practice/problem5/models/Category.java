package com.practice.problem5.models;

/**
 * Represents a category for products.
 */
public class Category {
    private String id;
    private String name;

    /**
     * Creates a new category with the specified details.
     *
     * @param id The unique category ID
     * @param name The name of the category
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Category(String id, String name) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the category ID.
     *
     * @return the category ID
     */
    public String getId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the category name.
     *
     * @return the category name
     */
    public String getName() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if this category is equal to another object.
     * Two categories are considered equal if they have the same ID.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the hash code of the category.
     * The hash code is based on the category ID.
     *
     * @return the hash code of the category
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("TODO");
    }
}