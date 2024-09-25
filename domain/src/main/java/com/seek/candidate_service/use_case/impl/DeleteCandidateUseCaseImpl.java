package com.seek.candidate_service.use_case.impl;

import com.seek.candidate_service.use_case.DeleteCandidateUseCase;
import drivenPort.drivenJpa.CandidateRepository;
import exceptions.CandidateNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteCandidateUseCaseImpl implements DeleteCandidateUseCase {
    private final CandidateRepository repository;

    @Override
    public void delete(UUID uuid) {
        try {
            repository.delete(uuid);
        } catch (RuntimeException runtimeException) {
            throw new CandidateNotFoundException(runtimeException.getMessage());
        }
    }
}
