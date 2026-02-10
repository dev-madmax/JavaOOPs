package com.practice.problem2.exceptions;

/**
 * Thrown when a slot is not available.
 */
public class SlotNotAvailableException extends RuntimeException {
    public SlotNotAvailableException(String message) {
        super(message);
    }
}