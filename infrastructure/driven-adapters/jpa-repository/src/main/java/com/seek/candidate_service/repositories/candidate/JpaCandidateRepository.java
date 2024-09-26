package com.seek.candidate_service.repositories.candidate;

import com.seek.candidate_service.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCandidateRepository extends JpaRepository<CandidateEntity, String> {
}
