package com.practice.problem7.services;

import com.practice.problem7.models.*;
import com.practice.problem7.exceptions.*;

/**
 * Provides zoo feeding operations.
 */
public class FeedingService {
    /**
     * Construct feeding service.
     */
    public FeedingService() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add an animal.
     * @param animal animal to add
     */
    public void addAnimal(Animal animal) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove an animal.
     * @param animalName name to remove
     */
    public void removeAnimal(String animalName) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Mark feeding for animal, food, and date.
     * @param animalName animal name
     * @param food food type
     * @param date feeding date
     */
    public void markFeeding(String animalName, String food, String date) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove a feeding record.
     * @param animalName animal name
     * @param date feeding date
     */
    public void removeFeedingRecord(String animalName, String date) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get feeding record for an animal and date.
     * @param animalName animal name
     * @param date feeding date
     * @return feeding record
     */
    public FeedingRecord getFeedingRecord(String animalName, String date) {
        throw new UnsupportedOperationException("TODO");
    }
}