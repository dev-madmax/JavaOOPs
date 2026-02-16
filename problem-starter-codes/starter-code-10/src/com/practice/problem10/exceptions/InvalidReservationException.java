package com.practice.problem10.exceptions;

public class InvalidReservationException extends RuntimeException{
    public InvalidReservationException(String message) {
        super(message);
    }
}
