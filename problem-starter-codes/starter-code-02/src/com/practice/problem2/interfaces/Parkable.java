package com.practice.problem2.interfaces;

/**
 * Represents parkable objects in parking system.
 */
public interface Parkable {
    /**
     * Mark as parked.
     */
    void park();

    /**
     * Mark as unparked.
     */
    void unpark();

    /**
     * Returns true if currently parked.
     * @return true if parked
     */
    boolean isParked();
}