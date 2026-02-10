package com.practice.problem13.models;

import com.practice.problem13.interfaces.Adoptable;

/**
 * Represents a pet.
 */
public class Pet implements Adoptable {
    /**
     * Construct a pet.
     * @param petId unique pet id
     * @param type pet type
     * @param color pet color
     */
    public Pet(String petId, String type, String color) {
        throw new UnsupportedOperationException("TODO");
    }

    public String getPetId() {
        throw new UnsupportedOperationException("TODO");
    }

    public String getType() {
        throw new UnsupportedOperationException("TODO");
    }

    public String getColor() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void adopt() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void returnPet() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean isAdopted() {
        throw new UnsupportedOperationException("TODO");
    }
}