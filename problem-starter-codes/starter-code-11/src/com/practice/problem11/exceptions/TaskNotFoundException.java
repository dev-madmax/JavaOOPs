package com.practice.problem11.exceptions;

/**
 * Thrown when a task is not found.
 */
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}