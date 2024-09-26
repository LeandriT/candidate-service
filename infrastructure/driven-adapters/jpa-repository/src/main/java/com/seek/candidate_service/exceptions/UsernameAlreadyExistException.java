package com.seek.candidate_service.exceptions;

public class UsernameAlreadyExistException extends RuntimeException {
    public UsernameAlreadyExistException() {
        super("username already taken");
    }
}