package com.seek.candidate_service.exceptions;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException() {
        super("role not found");
    }
}