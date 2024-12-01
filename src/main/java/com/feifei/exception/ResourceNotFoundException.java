package com.feifei.exception;

public class ResourceNotFoundException extends RuntimeException {
    private final int status;

    public ResourceNotFoundException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
