package com.seek.candidate_service.use_case.candidate.impl;

import com.seek.candidate_service.use_case.candidate.IndexCandidateUseCase;
import drivenPort.drivenJpa.candidate.CandidateRepository;
import entity.abstracts.PageBase;
import entity.candidate.Candidate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IndexCandidateUseCaseImpl implements IndexCandidateUseCase {
    private final CandidateRepository repository;

    @Override
    public PageBase<Candidate> index(Integer page, Integer size) {
        return repository.index(page, size);
    }
}
