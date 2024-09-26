package com.seek.candidate_service.repositories.token;

import com.seek.candidate_service.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JpaTokenRepository extends JpaRepository<TokenEntity, String> {


    @Query("""
            select t from TokenEntity t inner join UserEntity u on t.user.uuid = u.uuid
            where t.user.uuid = :userId and t.loggedOut = false
            """)
    List<TokenEntity> findAllTokensByUser(String userId);

    Optional<TokenEntity> findByToken(String token);
}
