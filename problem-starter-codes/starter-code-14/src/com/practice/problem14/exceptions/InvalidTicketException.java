package com.practice.problem14.exceptions;

public class InvalidTicketException extends RuntimeException{
    public InvalidTicketException(String message) {
        super(message);
    }
}
