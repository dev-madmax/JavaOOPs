package com.practice.problem10.models;

import com.practice.problem10.interfaces.Reservable;

/**
 * Represents a table in the restaurant.
 */
public class Table implements Reservable {
    /**
     * Construct a table with number and capacity.
     * @param tableNumber table number
     * @param capacity seat count
     */
    public Table(int tableNumber, int capacity) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get table number.
     */
    public int getTableNumber() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get capacity.
     */
    public int getCapacity() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void reserve(String date, String time) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void unreserve() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean isReserved() {
        throw new UnsupportedOperationException("TODO");
    }
}