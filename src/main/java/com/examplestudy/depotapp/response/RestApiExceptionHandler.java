package com.examplestudy.depotapp.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;

@RestController
@ControllerAdvice
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception e, WebRequest request){
        RestApiResponse exception =  new RestApiResponse(
                LocalTime.now(),
                e.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exception,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Throwable.class)
    public final ResponseEntity<Object> handleNotFoundException(Exception e, WebRequest request){
        RestApiResponse response = new RestApiResponse(
                LocalTime.now(),
                e.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleAlreadyExistException(Exception e, WebRequest request){
        RestApiResponse exception =  new RestApiResponse(
                LocalTime.now(),
                e.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exception,HttpStatus.NOT_ACCEPTABLE);
    }

}
