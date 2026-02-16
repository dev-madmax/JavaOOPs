package com.practice.problem7.exceptions;

public class InvalidFoodException extends RuntimeException{
    public InvalidFoodException(String message) {
        super(message);
    }
}
