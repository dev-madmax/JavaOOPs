package com.practice.problem12.exceptions;

public class InvalidBookingException extends RuntimeException{
    public InvalidBookingException(String message) {
        super(message);
    }
}
