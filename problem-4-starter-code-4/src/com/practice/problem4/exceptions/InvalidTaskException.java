package com.practice.problem4.exceptions;

/**
 * Exception thrown when a task is invalid according to business rules.
 */
public class InvalidTaskException extends Exception {
    /**
     * Constructs a new InvalidTaskException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidTaskException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidTaskException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public InvalidTaskException(String message, Throwable cause) {
        super(message, cause);
    }
}