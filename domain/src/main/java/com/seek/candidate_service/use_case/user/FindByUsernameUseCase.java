package com.seek.candidate_service.use_case.user;

import entity.userDetails.UserDetails;

import java.util.Optional;

public interface FindByUsernameUseCase {
    Optional<UserDetails> findByUsername(String username);
}
