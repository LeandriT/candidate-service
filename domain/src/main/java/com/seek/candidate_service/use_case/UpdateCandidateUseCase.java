package com.seek.candidate_service.use_case;

import entity.Candidate;

import java.util.UUID;

public interface UpdateCandidateUseCase {
    Candidate update(UUID uuid, Candidate candidate);
}
