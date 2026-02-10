package com.practice.problem7.exceptions;

/**
 * Thrown when duplicate feeding is detected for an animal on a day.
 */
public class DuplicateFeedingException extends RuntimeException {
    public DuplicateFeedingException(String message) {
        super(message);
    }
}