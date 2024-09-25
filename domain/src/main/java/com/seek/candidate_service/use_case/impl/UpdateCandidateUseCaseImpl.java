package com.seek.candidate_service.use_case.impl;

import com.seek.candidate_service.use_case.UpdateCandidateUseCase;
import drivenPort.drivenJpa.CandidateRepository;
import entity.Candidate;
import exceptions.CandidateNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateCandidateUseCaseImpl implements UpdateCandidateUseCase {
    private final CandidateRepository candidateRepository;

    @Override
    public Candidate update(UUID uuid, Candidate candidate) {
        try {
            return candidateRepository.update(uuid, candidate);
        } catch (RuntimeException runtimeException) {
            throw new CandidateNotFoundException(runtimeException.getMessage());
        }
    }
}
