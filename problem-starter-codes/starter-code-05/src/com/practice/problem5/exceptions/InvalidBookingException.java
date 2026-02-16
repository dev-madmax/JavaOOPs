package com.practice.problem5.exceptions;

public class InvalidBookingException extends RuntimeException{
    public InvalidBookingException(String message) {
        super(message);
    }
}
