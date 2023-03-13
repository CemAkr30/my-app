package com.example.application.exception;

public class DogrulamaException extends  Exception {

    private String message;

    public DogrulamaException(String message){
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }
}
