package com.seek.candidate_service.exceptions;

public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException() {
        super("token not found");
    }
}