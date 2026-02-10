package com.practice.problem4.exceptions;

/**
 * Thrown when attendance for a student on a date already exists.
 */
public class DuplicateAttendanceException extends RuntimeException {
    public DuplicateAttendanceException(String message) {
        super(message);
    }
}