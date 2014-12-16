package com.thoughtworks.trains.exception;

public class InvalidDataException extends RuntimeException
{
    public InvalidDataException(String message)
    {
        super(message);
    }
}
