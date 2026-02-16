package com.practice.problem6.exceptions;

public class InvalidOrderException extends RuntimeException{

    public InvalidOrderException(String message) {
        super(message);
    }
}
