package com.seek.candidate_service.exceptions;

public class CandidateNotFoundException extends RuntimeException {
    public CandidateNotFoundException() {
        super("candidate not found");
    }
}