package com.practice.problem8.exceptions;

/**
 * Thrown when duplicate song is detected.
 */
public class DuplicateSongException extends RuntimeException {
    public DuplicateSongException(String message) {
        super(message);
    }
}