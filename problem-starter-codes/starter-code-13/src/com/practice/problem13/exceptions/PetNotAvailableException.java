package com.practice.problem13.exceptions;

/**
 * Thrown when a pet is not available for adoption.
 */
public class PetNotAvailableException extends RuntimeException {
    public PetNotAvailableException(String message) {
        super(message);
    }
}