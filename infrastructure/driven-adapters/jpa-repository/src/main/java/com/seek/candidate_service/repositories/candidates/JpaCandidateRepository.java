package com.seek.candidate_service.repositories.candidates;

import com.seek.candidate_service.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaCandidateRepository extends JpaRepository<Candidate, UUID> {
}
