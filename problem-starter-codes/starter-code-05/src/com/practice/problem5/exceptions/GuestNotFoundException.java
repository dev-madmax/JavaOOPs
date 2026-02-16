package com.practice.problem5.exceptions;

public class GuestNotFoundException extends RuntimeException{
    public GuestNotFoundException(String message) {
        super(message);
    }
}
