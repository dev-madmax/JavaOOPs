package com.practice.problem2.services;

import com.practice.problem2.models.*;
import com.practice.problem2.exceptions.*;

/**
 * Provides core parking operations.
 */
public class ParkingLotService {
    /**
     * Construct service with parking lot capacity.
     * @param capacity max slots
     */
    public ParkingLotService(int capacity) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Park a vehicle.
     * @param vehicle vehicle to park
     */
    public void parkVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove a vehicle by id.
     * @param vehicleId vehicle identifier
     */
    public void removeVehicle(String vehicleId) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get slot by index.
     * @param slotIdx index
     * @return Slot object
     */
    public Slot getSlot(int slotIdx) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns true if all slots are full.
     * @return true if full
     */
    public boolean isFull() {
        throw new UnsupportedOperationException("TODO");
    }
}