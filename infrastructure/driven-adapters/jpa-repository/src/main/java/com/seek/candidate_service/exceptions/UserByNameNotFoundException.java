package com.seek.candidate_service.exceptions;

public class UserByNameNotFoundException extends RuntimeException {
    public UserByNameNotFoundException() {
        super("user by name not found");
    }
}