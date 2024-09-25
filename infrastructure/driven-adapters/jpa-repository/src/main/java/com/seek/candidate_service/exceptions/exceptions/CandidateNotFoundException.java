package com.seek.candidate_service.exceptions.exceptions;

public class CandidateNotFoundException extends RuntimeException {
    public CandidateNotFoundException() {
        super("candidate not found");
    }
}