package com.seek.candidate_service.use_case.token.impl;

import com.seek.candidate_service.use_case.token.UpdateTokenUseCase;
import drivenPort.drivenJpa.authentication.JwtRepository;
import entity.token.Token;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateTokenUseCaseImpl implements UpdateTokenUseCase {
    private final JwtRepository repository;

    @Override
    public Token updateToken(Token token) {
        return repository.updateToken(token);
    }
}
