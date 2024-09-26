package com.seek.candidate_service.use_case.candidate;

import entity.abstracts.PageBase;
import entity.candidate.Candidate;

public interface IndexCandidateUseCase {
    PageBase<Candidate> index(Integer page, Integer size);
}
