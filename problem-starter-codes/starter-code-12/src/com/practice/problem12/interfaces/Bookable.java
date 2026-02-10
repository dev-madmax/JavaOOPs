package com.practice.problem12.interfaces;

/**
 * Represents bookable flight entities.
 */
public interface Bookable {
    void book();
    void cancel();
    boolean isBooked();
}