package com.practice.problem5.models;

import com.practice.problem5.interfaces.Bookable;

/**
 * Represents a room in the hotel.
 */
public class Room implements Bookable {
    /**
     * Construct a room with number and type.
     * @param roomNumber room number
     * @param type room type
     */
    public Room(int roomNumber, String type) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get room number.
     * @return roomNumber
     */
    public int getRoomNumber() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get room type.
     * @return type
     */
    public String getType() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void book(String startDate, String endDate) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void unbook() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean isBooked() {
        throw new UnsupportedOperationException("TODO");
    }
}