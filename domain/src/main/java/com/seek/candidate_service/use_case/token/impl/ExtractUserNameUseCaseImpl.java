package com.seek.candidate_service.use_case.token.impl;

import com.seek.candidate_service.use_case.token.ExtractUserNameUseCase;
import drivenPort.drivenJpa.authentication.JwtRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExtractUserNameUseCaseImpl implements ExtractUserNameUseCase {
    private final JwtRepository repository;

    @Override
    public String extractUsername(String username) {
        return repository.extractUsername(username);
    }
}
