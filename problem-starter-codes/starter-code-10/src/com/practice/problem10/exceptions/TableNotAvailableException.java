package com.practice.problem10.exceptions;

/**
 * Thrown when a table is not available for reservation.
 */
public class TableNotAvailableException extends RuntimeException {
    public TableNotAvailableException(String message) {
        super(message);
    }
}