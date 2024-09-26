package com.seek.candidate_service.use_case.token;

import entity.token.Token;

import java.util.Optional;

public interface FindByTokenUseCase {

    Optional<Token> findByToken(String token);
}
