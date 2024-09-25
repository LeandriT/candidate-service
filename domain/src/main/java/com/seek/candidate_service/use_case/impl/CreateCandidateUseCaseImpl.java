package com.seek.candidate_service.use_case.impl;

import com.seek.candidate_service.use_case.CreateCandidateUseCase;
import drivenPort.drivenJpa.CandidateRepository;
import entity.Candidate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCandidateUseCaseImpl implements CreateCandidateUseCase {
    private final CandidateRepository candidateRepository;

    @Override
    public Candidate create(Candidate candidate) {
        return candidateRepository.create(candidate);
    }
}
