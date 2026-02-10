package com.practice.problem1.services;

import com.practice.problem1.models.*;
import com.practice.problem1.exceptions.*;

/**
 * Provides operations on library books and members.
 */
public class LibraryService {
    /**
     * Construct the service.
     */
    public LibraryService() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add a book to the library.
     * @param book the book to add
     */
    public void addBook(Book book) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove a book by its ISBN.
     * @param isbn the isbn of the book
     */
    public void removeBook(String isbn) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add a member to the library.
     * @param member member to add
     */
    public void addMember(Member member) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove a member by member id.
     * @param memberId the id to remove
     */
    public void removeMember(int memberId) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Borrow a book for a member.
     * @param memberId member id
     * @param isbn book isbn
     */
    public void borrowBook(int memberId, String isbn) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return a book from a member.
     * @param memberId member id
     * @param isbn book isbn
     */
    public void returnBook(int memberId, String isbn) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Check if a book is borrowed.
     * @param isbn book isbn
     * @return true if borrowed
     */
    public boolean isBookBorrowed(String isbn) {
        throw new UnsupportedOperationException("TODO");
    }
}