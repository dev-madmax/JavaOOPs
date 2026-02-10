package com.practice.problem6.models;

import com.practice.problem6.interfaces.Orderable;

/**
 * Represents a menu item in coffee shop.
 */
public class MenuItem implements Orderable {
    /**
     * Construct menu item with name and price.
     * @param name item name
     * @param price item price
     */
    public MenuItem(String name, double price) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public double getPrice() {
        throw new UnsupportedOperationException("TODO");
    }
}