package com.seek.candidate_service.use_case.impl;

import com.seek.candidate_service.use_case.IndexCandidateUseCase;
import drivenPort.drivenJpa.CandidateRepository;
import entity.Candidate;
import entity.abstracts.PageBase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IndexCandidateUseCaseImpl implements IndexCandidateUseCase {
    private final CandidateRepository repository;

    @Override
    public PageBase<Candidate> index(Integer page, Integer size) {
        return repository.index(page, size);
    }
}
