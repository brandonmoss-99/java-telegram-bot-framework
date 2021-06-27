package com.brandythewuff;


public class InvalidParamsException extends Exception{
    String message;

    public InvalidParamsException(String msg, Throwable err){
        super(msg, err);
    }

    public InvalidParamsException(String msg){
        message = msg;
    }

    // Override default getMessage() behaviour of Exception class,
    // to return our custom error message
    @Override
    public String getMessage(){
        return message;
    }

    public String toString(){
        return("InvalidParamsException: " + message);
    }
}