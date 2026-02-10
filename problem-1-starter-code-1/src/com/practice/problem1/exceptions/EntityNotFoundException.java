package com.practice.problem1.exceptions;

/**
 * Exception thrown when attempting to access an entity that does not exist.
 */
public class EntityNotFoundException extends Exception {
    /**
     * Constructs a new EntityNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public EntityNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new EntityNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}