package com.practice.problem7.exceptions;

/**
 * Thrown when an animal is not found.
 */
public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(String message) {
        super(message);
    }
}