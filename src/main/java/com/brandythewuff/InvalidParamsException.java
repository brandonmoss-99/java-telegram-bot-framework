package com.brandythewuff;


public class InvalidParamsException extends Exception{
    String message;

    public InvalidParamsException(String msg, Throwable err){
        super(msg, err);
    }

    public InvalidParamsException(String msg){
        message = msg;
    }

    public String toString(){
        return("InvalidParamsException: " + message);
    }
}