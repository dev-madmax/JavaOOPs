package com.practice.problem12.exceptions;

/**
 * Thrown when a flight is not available for booking.
 */
public class FlightNotAvailableException extends RuntimeException {
    public FlightNotAvailableException(String message) {
        super(message);
    }
}