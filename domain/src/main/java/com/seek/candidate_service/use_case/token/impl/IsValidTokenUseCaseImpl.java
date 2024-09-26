package com.seek.candidate_service.use_case.token.impl;

import com.seek.candidate_service.use_case.token.IsValidTokenUseCase;
import drivenPort.drivenJpa.authentication.JwtRepository;
import entity.userDetails.UserDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsValidTokenUseCaseImpl implements IsValidTokenUseCase {
    private final JwtRepository repository;

    @Override
    public Boolean isValidToken(String token, UserDetails userDetails) {
        return repository.isValid(token, userDetails);
    }
}
