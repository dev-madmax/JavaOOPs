package com.practice.problem5.exceptions;

/**
 * Exception thrown when a product is invalid according to business rules.
 */
public class InvalidProductException extends Exception {
    /**
     * Constructs a new InvalidProductException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidProductException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidProductException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public InvalidProductException(String message, Throwable cause) {
        super(message, cause);
    }
}