package com.practice.problem14.exceptions;

/**
 * Thrown when a customer is not found.
 */
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}