package com.practice.problem4.exceptions;

/**
 * Thrown when the attendance date is invalid.
 */
public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String message) {
        super(message);
    }
}