package com.seek.candidate_service.use_case.candidate.impl;

import com.seek.candidate_service.use_case.candidate.CreateCandidateUseCase;
import drivenPort.drivenJpa.candidate.CandidateRepository;
import entity.candidate.Candidate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCandidateUseCaseImpl implements CreateCandidateUseCase {
    private final CandidateRepository candidateRepository;

    @Override
    public Candidate create(Candidate candidate) {
        return candidateRepository.create(candidate);
    }
}
