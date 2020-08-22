package com.existential.atom.exception;

public class ApplicationException extends Exception {

    public ApplicationException() {
        this("Something gone wrong");
    }

    public ApplicationException(String message) {
        super(message);
    }
}
