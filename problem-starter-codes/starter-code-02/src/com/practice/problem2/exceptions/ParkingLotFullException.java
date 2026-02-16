package com.practice.problem2.exceptions;

public class ParkingLotFullException extends RuntimeException{
    public ParkingLotFullException(String message) {
        super(message);
    }
}
