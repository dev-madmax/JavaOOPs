package com.practice.problem2.exceptions;

/**
 * Exception thrown when attempting to withdraw more funds than available in an account.
 */
public class InsufficientFundsException extends Exception {
    /**
     * Constructs a new InsufficientFundsException with the specified detail message.
     *
     * @param message the detail message
     */
    public InsufficientFundsException(String message) {
        super(message);
    }

    /**
     * Constructs a new InsufficientFundsException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}