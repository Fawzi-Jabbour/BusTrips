package com.fawzi.org.bustrips.exceptions;

public class SeatNotFoundException extends RuntimeException{
    public SeatNotFoundException(String message){
        super(message);
    }
}
