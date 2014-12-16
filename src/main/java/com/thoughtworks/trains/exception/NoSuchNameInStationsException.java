package com.thoughtworks.trains.exception;

public class NoSuchNameInStationsException extends RuntimeException
{
    public NoSuchNameInStationsException(String message)
    {
        super(message);
    }
}
