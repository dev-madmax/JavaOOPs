package com.practice.problem6.exceptions;

/**
 * Thrown when a menu item is not found.
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}