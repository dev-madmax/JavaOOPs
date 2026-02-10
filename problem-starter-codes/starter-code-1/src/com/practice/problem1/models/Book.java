package com.practice.problem1.models;

import com.practice.problem1.interfaces.Borrowable;

/**
 * Represents a Book in the library.
 */
public class Book implements Borrowable {
    /**
     * Construct a Book with given ISBN, title, and author.
     * @param isbn the ISBN
     * @param title the title
     * @param author the author
     */
    public Book(String isbn, String title, String author) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get the ISBN of the book.
     * @return isbn
     */
    public String getIsbn() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get the title of the book.
     * @return title
     */
    public String getTitle() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get the author of the book.
     * @return author
     */
    public String getAuthor() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void borrow(int memberId) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void returnItem() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean isBorrowed() {
        throw new UnsupportedOperationException("TODO");
    }
}