package com.seek.candidate_service.use_case.impl;

import com.seek.candidate_service.use_case.ShowCandidateUseCase;
import drivenPort.drivenJpa.CandidateRepository;
import entity.Candidate;
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
