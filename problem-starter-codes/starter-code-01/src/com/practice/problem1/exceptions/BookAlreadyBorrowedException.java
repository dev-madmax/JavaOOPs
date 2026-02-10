package com.practice.problem1.exceptions;

/**
 * Thrown when a book is already borrowed.
 */
public class BookAlreadyBorrowedException extends RuntimeException {
    public BookAlreadyBorrowedException(String message) {
        super(message);
    }
}