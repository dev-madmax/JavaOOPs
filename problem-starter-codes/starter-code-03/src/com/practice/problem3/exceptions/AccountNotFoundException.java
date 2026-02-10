package com.practice.problem3.exceptions;

/**
 * Thrown if an account or customer is not found.
 */
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}