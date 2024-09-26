package com.seek.candidate_service.use_case.candidate.impl;

import com.seek.candidate_service.use_case.candidate.ShowCandidateUseCase;
import drivenPort.drivenJpa.candidate.CandidateRepository;
import entity.candidate.Candidate;
import exceptions.CandidateNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ShowCandidateUseCaseImpl implements ShowCandidateUseCase {
    private final CandidateRepository repository;

    @Override
    public Candidate show(UUID uuid) {
        try {
            return repository.show(uuid);
        } catch (RuntimeException runtimeException) {
            throw new CandidateNotFoundException(runtimeException.getMessage());
        }
    }
}
