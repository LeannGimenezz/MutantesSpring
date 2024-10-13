package com.mutante.app.utils.exceptions;

public class DnaAlreadyExistsException extends RuntimeException {
    public DnaAlreadyExistsException(String message) {
        super(message);
    }
}