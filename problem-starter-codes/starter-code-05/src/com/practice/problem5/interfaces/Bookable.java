package com.practice.problem5.interfaces;

/**
 * Represents bookable entities.
 */
public interface Bookable {
    /**
     * Book for specified date range.
     * @param startDate booking start date
     * @param endDate booking end date
     */
    void book(String startDate, String endDate);

    /**
     * Cancel/unbook.
     */
    void unbook();

    /**
     * Returns true if currently booked.
     * @return true if booked
     */
    boolean isBooked();
}