package com.tlc.exeption;

/**
 * Represents custom Exception class for wrap internal exception during application running
 */
public class InvalidLinkException extends RuntimeException {
    public InvalidLinkException(String message) {
        super(message);
    }
}
