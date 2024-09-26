package com.seek.candidate_service.use_case.token.impl;

import com.seek.candidate_service.use_case.token.FindByTokenUseCase;
import drivenPort.drivenJpa.authentication.JwtRepository;
import entity.token.Token;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FindByTokenUseCaseImpl implements FindByTokenUseCase {
    private final JwtRepository repository;

    @Override
    public Optional<Token> findByToken(String token) {
        return repository.findByToken(token);
    }
}
