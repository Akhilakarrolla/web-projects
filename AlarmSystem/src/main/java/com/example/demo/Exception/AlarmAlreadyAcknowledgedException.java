package com.example.demo.Exception;

public class AlarmAlreadyAcknowledgedException extends RuntimeException{
    public AlarmAlreadyAcknowledgedException(String message) {
        super(message);
    }
}
