package com.practice.problem1.models;

/**
 * Represents a book with ISBN, title, author, and publication year.
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;

    /**
     * Creates a new book with the specified details.
     *
     * @param isbn The ISBN of the book
     * @param title The title of the book
     * @param author The author of the book
     * @param publicationYear The publication year of the book
     */
    public Book(String isbn, String title, String author, int publicationYear) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return the ISBN of the book
     */
    public String getIsbn() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the author of the book.
     *
     * @return the author of the book
     */
    public String getAuthor() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the publication year of the book.
     *
     * @return the publication year of the book
     */
    public int getPublicationYear() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if this book is equal to another object.
     * Two books are considered equal if they have the same ISBN.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the hash code of the book.
     * The hash code is based on the ISBN.
     *
     * @return the hash code of the book
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("TODO");
    }
}