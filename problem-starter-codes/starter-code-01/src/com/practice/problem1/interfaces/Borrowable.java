package com.practice.problem1.interfaces;

/**
 * Represents borrowable objects in the library system.
 */
public interface Borrowable {
    /**
     * Mark as borrowed by a member.
     * @param memberId borrower member id
     */
    void borrow(int memberId);

    /**
     * Mark as returned.
     */
    void returnItem();

    /**
     * Returns true if currently borrowed.
     * @return true if borrowed
     */
    boolean isBorrowed();
}