package com.examplestudy.depotapp.response;

import java.time.LocalTime;

public class AlreadyExistException extends  RuntimeException{
    public AlreadyExistException(String message){
        super(message);
    }
}
