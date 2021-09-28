package com.examplestudy.depotapp.response;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class RestApiResponse {
    public RestApiResponse(LocalTime timestamp, String message, String details){
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }
    private LocalTime timestamp;
    private String message;
    private String details;
}
