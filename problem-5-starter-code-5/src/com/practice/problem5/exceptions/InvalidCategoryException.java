package com.practice.problem5.exceptions;

/**
 * Exception thrown when a category is invalid according to business rules.
 */
public class InvalidCategoryException extends Exception {
    /**
     * Constructs a new InvalidCategoryException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidCategoryException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidCategoryException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public InvalidCategoryException(String message, Throwable cause) {
        super(message, cause);
    }
}