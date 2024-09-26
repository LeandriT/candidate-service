package com.seek.candidate_service.repositories.user;

import com.seek.candidate_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserDetails> findByUsername(String username);
}
