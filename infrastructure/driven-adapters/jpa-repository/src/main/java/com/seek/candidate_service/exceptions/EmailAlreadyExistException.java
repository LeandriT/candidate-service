package com.seek.candidate_service.exceptions;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException() {
        super("email already exist");
    }
}