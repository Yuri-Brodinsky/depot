package com.examplestudy.depotapp.response;

import java.time.LocalTime;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
