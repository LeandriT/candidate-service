package com.seek.candidate_service.use_case;

import entity.Candidate;
import entity.abstracts.PageBase;

public interface IndexCandidateUseCase {
    PageBase<Candidate> index(Integer page, Integer size);
}
