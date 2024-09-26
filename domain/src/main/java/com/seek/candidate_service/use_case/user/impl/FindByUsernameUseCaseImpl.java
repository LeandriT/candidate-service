package com.seek.candidate_service.use_case.user.impl;

import com.seek.candidate_service.use_case.user.FindByUsernameUseCase;
import drivenPort.drivenJpa.authentication.AuthenticationRepository;
import entity.userDetails.UserDetails;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FindByUsernameUseCaseImpl implements FindByUsernameUseCase {
    private final AuthenticationRepository repository;

    @Override
    public Optional<UserDetails> findByUsername(String username) {
        return repository.findByUsername2(username);
    }
}
