package com.practice.problem15.exceptions;

public class CropNotFoundException extends RuntimeException{
    public CropNotFoundException(String message) {
        super(message);
    }
}
