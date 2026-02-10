package com.practice.problem1.models;

import com.practice.problem1.exceptions.DuplicateEntityException;

/**
 * Represents a library that manages a collection of books.
 */
public class Library {
    private String name;
    private int capacity;
    private int currentSize;

    /**
     * Creates a new library with the specified name and capacity.
     *
     * @param name The name of the library
     * @param capacity The maximum number of books the library can hold
     */
    public Library(String name, int capacity) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the name of the library.
     *
     * @return the name of the library
     */
    public String getName() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the maximum capacity of the library.
     *
     * @return the maximum number of books the library can hold
     */
    public int getCapacity() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the current number of books in the library.
     *
     * @return the current number of books
     */
    public int getCurrentSize() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Adds a book to the library.
     *
     * @param book The book to add
     * @throws DuplicateEntityException if a book with the same ISBN already exists
     * @throws IllegalStateException if the library is at capacity
     */
    public void addBook(Book book) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Finds a book by its ISBN.
     *
     * @param isbn The ISBN of the book to find
     * @return the book with the specified ISBN, or null if not found
     */
    public Book findBookByIsbn(String isbn) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Removes a book by its ISBN.
     *
     * @param isbn The ISBN of the book to remove
     * @return true if the book was removed, false if not found
     */
    public boolean removeBookByIsbn(String isbn) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Clears all books from the library.
     */
    public void clearAllBooks() {
        throw new UnsupportedOperationException("TODO");
    }
}