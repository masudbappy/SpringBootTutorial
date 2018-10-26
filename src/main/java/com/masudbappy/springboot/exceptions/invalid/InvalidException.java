package com.masudbappy.springboot.exceptions.invalid;

public class InvalidException extends Throwable{
    public InvalidException() {
    }

    public InvalidException(String message) {
        super(message);
    }

    public InvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidException(Throwable cause) {
        super(cause);
    }

    public InvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
