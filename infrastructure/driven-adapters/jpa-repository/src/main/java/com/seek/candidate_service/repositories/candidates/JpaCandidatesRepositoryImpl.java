package com.seek.candidate_service.repositories.candidates;

import com.seek.candidate_service.entity.CandidateEntity;
import com.seek.candidate_service.exceptions.exceptions.CandidateNotFoundException;
import com.seek.candidate_service.mapper.CandidateMapperJpa;
import drivenPort.drivenJpa.CandidateRepository;
import entity.Candidate;
import entity.abstracts.PageBase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaCandidatesRepositoryImpl implements CandidateRepository {
    private final JpaCandidateRepository jpaCandidateRepository;
    private final CandidateMapperJpa candidateMapperJpa;

    @Override
    public Candidate create(Candidate candidate) {
        CandidateEntity candidateEntity = candidateMapperJpa.toEntityJpa(candidate);
        jpaCandidateRepository.save(candidateEntity);
        return candidateMapperJpa.toEntityDomain(candidateEntity);
    }

    @Override
    public Candidate update(UUID uuid, Candidate candidate) {
        CandidateEntity entity = jpaCandidateRepository.findById(uuid.toString())
                .orElseThrow(CandidateNotFoundException::new);
        CandidateEntity candidateEntity = candidateMapperJpa.updateModel(candidate, entity);
        jpaCandidateRepository.save(candidateEntity);
        return candidateMapperJpa.toEntityDomain(candidateEntity);
    }

    @Override
    public PageBase<Candidate> index(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CandidateEntity> candidateEntityPage = jpaCandidateRepository.findAll(pageable);
        return PageBase.<Candidate>builder()
                .totalPages(candidateEntityPage.getTotalPages())
                .page(page)
                .size(size)
                .totalElements(candidateEntityPage.getNumberOfElements())
                .empty(candidateEntityPage.isEmpty())
                .content(candidateEntityPage.getContent().stream().map(candidateMapperJpa::toEntityDomain).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Candidate show(UUID uuid) {
        CandidateEntity entity = jpaCandidateRepository.findById(uuid.toString())
                .orElseThrow(CandidateNotFoundException::new);
        return candidateMapperJpa.toEntityDomain(entity);
    }

    @Override
    public void delete(UUID uuid) {
        CandidateEntity candidateEntity = jpaCandidateRepository.findById(uuid.toString())
                .orElseThrow(CandidateNotFoundException::new);
        jpaCandidateRepository.delete(candidateEntity);
    }
}
