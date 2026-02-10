package com.practice.problem1.exceptions;

/**
 * Exception thrown when attempting to add a duplicate entity to a collection.
 */
public class DuplicateEntityException extends Exception {
    /**
     * Constructs a new DuplicateEntityException with the specified detail message.
     *
     * @param message the detail message
     */
    public DuplicateEntityException(String message) {
        super(message);
    }

    /**
     * Constructs a new DuplicateEntityException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public DuplicateEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}