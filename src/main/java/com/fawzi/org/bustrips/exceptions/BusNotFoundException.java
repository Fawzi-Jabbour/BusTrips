package com.fawzi.org.bustrips.exceptions;

public class BusNotFoundException extends RuntimeException{
    public BusNotFoundException(String message){
        super(message);
    }
}
