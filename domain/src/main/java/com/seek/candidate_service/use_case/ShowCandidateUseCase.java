package com.seek.candidate_service.use_case;

import entity.Candidate;

import java.util.UUID;

public interface ShowCandidateUseCase {
    Candidate show(UUID uuid);
}
