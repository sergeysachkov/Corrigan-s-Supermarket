package com.ait.corrigan.exception;

/**
 * Created by root on 11/17/2016.
 */
public class CorriganException extends RuntimeException {
    public CorriganException() {
        super();
    }

    public CorriganException(String message) {
        super(message);
    }

    public CorriganException(String message, Throwable cause) {
        super(message, cause);
    }
}
