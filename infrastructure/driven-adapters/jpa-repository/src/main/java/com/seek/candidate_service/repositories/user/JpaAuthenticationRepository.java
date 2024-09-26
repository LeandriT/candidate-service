package com.seek.candidate_service.repositories.user;


import com.seek.candidate_service.entity.UserEntity;

import java.util.Optional;

public interface JpaAuthenticationRepository {

    Optional<UserEntity> findByUsername(String username);
}
