package com.fawzi.org.bustrips.exceptions;

public class DuplicateDestinationCodeException extends RuntimeException{
    public DuplicateDestinationCodeException(String message) {
        super(message);
    }
}
