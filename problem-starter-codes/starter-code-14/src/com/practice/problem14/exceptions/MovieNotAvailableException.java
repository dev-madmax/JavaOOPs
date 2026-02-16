package com.practice.problem14.exceptions;

public class MovieNotAvailableException extends RuntimeException{
    public MovieNotAvailableException(String message) {
        super(message);
    }
}
