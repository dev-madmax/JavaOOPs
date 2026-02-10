package com.practice.problem7.models;

import com.practice.problem7.interfaces.Feedable;

/**
 * Represents an animal in the zoo.
 */
public class Animal implements Feedable {
    /**
     * Constructs an animal with name and species.
     * @param name animal name
     * @param species animal species
     */
    public Animal(String name, String species) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get animal name.
     * @return name
     */
    @Override
    public String getAnimalName() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get animal species.
     * @return species
     */
    public String getSpecies() {
        throw new UnsupportedOperationException("TODO");
    }
}