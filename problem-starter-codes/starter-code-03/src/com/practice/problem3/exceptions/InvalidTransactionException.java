package com.practice.problem3.exceptions;

/**
 * Thrown if a transaction is invalid (e.g. negative, malformed).
 */
public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}