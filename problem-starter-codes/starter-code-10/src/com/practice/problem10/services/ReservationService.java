package com.practice.problem10.services;

import com.practice.problem10.models.*;
import com.practice.problem10.exceptions.*;

/**
 * Provides restaurant reservation operations.
 */
public class ReservationService {
    /**
     * Construct service.
     */
    public ReservationService() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add customer.
     * @param customer customer to add
     */
    public void addCustomer(Customer customer) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove customer.
     * @param customerId customer id
     */
    public void removeCustomer(int customerId) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add a table.
     * @param table table to add
     */
    public void addTable(Table table) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove table.
     * @param tableNumber table number
     */
    public void removeTable(int tableNumber) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Reserve table for customer at date/time.
     * @param customerId customer id
     * @param tableNumber table number
     * @param date date
     * @param time time
     * @return reservation object
     */
    public Reservation reserveTable(int customerId, int tableNumber, String date, String time) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Cancel reservation by id.
     * @param reservationId reservation id
     */
    public void cancelReservation(String reservationId) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Check table is reserved for date/time.
     * @param tableNumber table number
     * @param date date
     * @param time time
     * @return true if reserved
     */
    public boolean isTableReserved(int tableNumber, String date, String time) {
        throw new UnsupportedOperationException("TODO");
    }
}