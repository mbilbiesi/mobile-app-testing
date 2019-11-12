package com.hs.mobile.exception;

public class TestExecutionException extends RuntimeException {
    public TestExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}