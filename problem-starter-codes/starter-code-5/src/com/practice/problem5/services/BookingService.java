package com.practice.problem5.services;

import com.practice.problem5.models.*;
import com.practice.problem5.exceptions.*;

/**
 * Provides core hotel booking operations.
 */
public class BookingService {
    /**
     * Construct booking service.
     */
    public BookingService() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add a guest.
     * @param guest guest to add
     */
    public void addGuest(Guest guest) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove a guest.
     * @param guestId id to remove
     */
    public void removeGuest(int guestId) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add a room.
     * @param room room to add
     */
    public void addRoom(Room room) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove a room.
     * @param roomNumber room number to remove
     */
    public void removeRoom(int roomNumber) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Book a room for guest.
     * @param guestId guest id
     * @param roomNumber room number
     * @param startDate booking start
     * @param endDate booking end
     * @return booking object
     */
    public Booking bookRoom(int guestId, int roomNumber, String startDate, String endDate) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Cancel a booking by id.
     * @param bookingId unique booking identifier
     */
    public void cancelBooking(String bookingId) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Check if room is booked.
     * @param roomNumber room number
     * @return true if booked
     */
    public boolean isRoomBooked(int roomNumber) {
        throw new UnsupportedOperationException("TODO");
    }
}