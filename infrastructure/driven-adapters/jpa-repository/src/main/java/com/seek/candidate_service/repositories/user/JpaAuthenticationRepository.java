package com.seek.candidate_service.repositories.user;


import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface JpaAuthenticationRepository {

    Optional<UserDetails> findByUsername(String username);
}
