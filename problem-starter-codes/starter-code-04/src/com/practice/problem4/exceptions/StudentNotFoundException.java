package com.practice.problem4.exceptions;

/**
 * Thrown when a student is not found.
 */
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}