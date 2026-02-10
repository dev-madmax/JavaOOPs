package com.practice.problem2.exceptions;

/**
 * Exception thrown when an invalid amount is provided for financial operations.
 * An invalid amount is typically negative or zero.
 */
public class InvalidAmountException extends Exception {
    /**
     * Constructs a new InvalidAmountException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidAmountException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidAmountException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public InvalidAmountException(String message, Throwable cause) {
        super(message, cause);
    }
}