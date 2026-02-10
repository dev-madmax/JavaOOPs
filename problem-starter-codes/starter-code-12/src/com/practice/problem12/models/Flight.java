package com.practice.problem12.models;

import com.practice.problem12.interfaces.Bookable;

/**
 * Represents a flight.
 */
public class Flight implements Bookable {
    /**
     * Construct a flight.
     * @param flightNumber flight number
     * @param origin origin city
     * @param destination destination city
     * @param date flight date
     * @param capacity seat count
     */
    public Flight(String flightNumber, String origin, String destination, String date, int capacity) {
        throw new UnsupportedOperationException("TODO");
    }

    public String getFlightNumber() {
        throw new UnsupportedOperationException("TODO");
    }

    public String getOrigin() {
        throw new UnsupportedOperationException("TODO");
    }

    public String getDestination() {
        throw new UnsupportedOperationException("TODO");
    }

    public String getDate() {
        throw new UnsupportedOperationException("TODO");
    }

    public int getCapacity() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void book() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean isBooked() {
        throw new UnsupportedOperationException("TODO");
    }
}