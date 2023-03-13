package com.example.application.exception.controlAdviceException;

import com.example.application.exception.UserException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> handleAuthenticationException(Exception e){
            return new ResponseEntity<Object>(
                    e.getMessage(), new HttpHeaders(),HttpStatus.NOT_ACCEPTABLE);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> genelHata(Exception e){
        return new ResponseEntity<Object>(
                e.getMessage(), new HttpHeaders(),HttpStatus.BAD_REQUEST);
    }
}
