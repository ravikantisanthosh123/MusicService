package com.stackroute.musicservice.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Cont
{
    @ExceptionHandler({MusicAlreadyExistsException.class, MusicNotFoundException.class})
    public ResponseEntity<String> exceptionhandler(Exception e) {
        return new ResponseEntity<>("Global Exception Here " + e.getMessage(), HttpStatus.CONFLICT);
    }
}