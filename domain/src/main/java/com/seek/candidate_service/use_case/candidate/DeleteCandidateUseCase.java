package com.seek.candidate_service.use_case.candidate;

import java.util.UUID;

public interface DeleteCandidateUseCase {
    void delete(UUID uuid);
}
