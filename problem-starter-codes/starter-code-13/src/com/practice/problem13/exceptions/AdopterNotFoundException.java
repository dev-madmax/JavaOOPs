package com.practice.problem13.exceptions;

public class AdopterNotFoundException extends RuntimeException{
    public AdopterNotFoundException(String message) {
        super(message);
    }
}
