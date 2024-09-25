package com.seek.candidate_service.use_case;

import entity.Candidate;

public interface CreateCandidateUseCase {
    Candidate create(Candidate candidate);
}
