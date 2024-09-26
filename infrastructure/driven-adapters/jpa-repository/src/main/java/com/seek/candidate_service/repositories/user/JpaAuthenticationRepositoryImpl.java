package com.seek.candidate_service.repositories.user;

import com.seek.candidate_service.entity.UserEntity;
import drivenPort.drivenJpa.authentication.AuthenticationRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaAuthenticationRepositoryImpl implements AuthenticationRepository, JpaAuthenticationRepository {


    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<entity.userDetails.UserDetails> findByUsername2(String username) {
        return Optional.empty();
    }
}
