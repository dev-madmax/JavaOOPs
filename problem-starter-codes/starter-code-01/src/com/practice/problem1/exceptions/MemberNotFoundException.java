package com.practice.problem1.exceptions;

/**
 * Thrown when a member is not found.
 */
public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String message) {
        super(message);
    }
}