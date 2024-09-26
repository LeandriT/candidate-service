package com.seek.candidate_service.use_case.candidate;

import entity.candidate.Candidate;

public interface CreateCandidateUseCase {
    Candidate create(Candidate candidate);
}
