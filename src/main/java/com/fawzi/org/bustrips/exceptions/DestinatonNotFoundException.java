package com.fawzi.org.bustrips.exceptions;

import com.fawzi.org.bustrips.entities.Destination;

public class DestinatonNotFoundException extends RuntimeException{
    public DestinatonNotFoundException(String message){
        super(message);
    }
}
