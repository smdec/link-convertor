package com.tlc.exeption;

public class ErrorDto extends RuntimeException {
    private final String status;

    public ErrorDto(String message, String status) {
        super(message);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
