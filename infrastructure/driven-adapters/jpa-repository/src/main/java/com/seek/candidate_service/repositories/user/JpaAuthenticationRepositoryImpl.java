package com.seek.candidate_service.repositories.user;

import com.seek.candidate_service.mapper.TokenMapperJpa;
import com.seek.candidate_service.mapper.UserMapperJpa;
import com.seek.candidate_service.repositories.token.JpaTokenRepository;
import com.seek.candidate_service.repositories.token.JwtRepositoryImpl;
import drivenPort.drivenJpa.authentication.AuthenticationRepository;
import entity.userDetails.UserDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaAuthenticationRepositoryImpl implements AuthenticationRepository, JpaAuthenticationRepository {
    @Lazy
    private final JpaUserRepository repository;
    @Lazy
    private final PasswordEncoder passwordEncoder;
    @Lazy
    private final JwtRepositoryImpl jwtService;
    @Lazy
    private final JpaTokenRepository tokenRepository;
    @Lazy
    private final TokenMapperJpa tokenMapperJpa;
    @Lazy
    private final UserMapperJpa userMapperJpa;

    public JpaAuthenticationRepositoryImpl(JpaUserRepository repository,
                                           PasswordEncoder passwordEncoder,
                                           JwtRepositoryImpl jwtService, JpaTokenRepository tokenRepository,
                                           TokenMapperJpa tokenMapperJpa,
                                           UserMapperJpa userMapperJpa) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.tokenMapperJpa = tokenMapperJpa;
        this.userMapperJpa = userMapperJpa;
    }

    @Override
    public Optional<UserDetails> findByUsername2(String username) {
        return repository.findByUsername(username).map(item ->
                UserDetails.builder()
                        .username(item.getUsername())
                        .password(item.getPassword())
                        .build()
        );
    }

    @Override
    public Optional<org.springframework.security.core.userdetails.UserDetails> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
