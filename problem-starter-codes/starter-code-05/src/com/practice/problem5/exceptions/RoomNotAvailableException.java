package com.practice.problem5.exceptions;

/**
 * Thrown when a room is not available for booking.
 */
public class RoomNotAvailableException extends RuntimeException {
    public RoomNotAvailableException(String message) {
        super(message);
    }
}