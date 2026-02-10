package com.practice.problem9.exceptions;

/**
 * Thrown when duplicate member is detected.
 */
public class DuplicateMemberException extends RuntimeException {
    public DuplicateMemberException(String message) {
        super(message);
    }
}