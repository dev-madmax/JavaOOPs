package com.practice.problem2.models;

import com.practice.problem2.interfaces.Parkable;

/**
 * Represents a vehicle.
 */
public class Vehicle implements Parkable {
    /**
     * Construct a vehicle with id and type.
     * @param vehicleId unique vehicle identifier
     * @param type vehicle type
     */
    public Vehicle(String vehicleId, String type) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get vehicle ID.
     * @return vehicleId
     */
    public String getVehicleId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get vehicle type.
     * @return type
     */
    public String getType() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void park() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void unpark() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean isParked() {
        throw new UnsupportedOperationException("TODO");
    }
}