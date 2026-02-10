package com.practice.problem8.exceptions;

/**
 * Thrown for invalid playlist operations.
 */
public class InvalidPlaylistOperationException extends RuntimeException {
    public InvalidPlaylistOperationException(String message) {
        super(message);
    }
}