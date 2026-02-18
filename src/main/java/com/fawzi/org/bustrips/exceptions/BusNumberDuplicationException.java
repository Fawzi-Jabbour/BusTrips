package com.fawzi.org.bustrips.exceptions;

public class BusNumberDuplicationException extends RuntimeException{
    public BusNumberDuplicationException(String message){
        super(message);
    }
}
