package com.seek.candidate_service.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seek.candidate_service.dto.abstracts.PageBaseDto;
import com.seek.candidate_service.dto.candidate.request.CandidateRequest;
import com.seek.candidate_service.dto.candidate.response.CandidateResponse;
import com.seek.candidate_service.mapper.CandidateMapper;
import com.seek.candidate_service.retentions.OnCreate;
import com.seek.candidate_service.use_case.*;
import entity.Candidate;
import entity.abstracts.PageBase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/candidates")
@RequiredArgsConstructor
@Validated
public class CandidateController {
    private final CreateCandidateUseCase createCandidateUseCase;
    private final UpdateCandidateUseCase updateCandidateUseCase;
    private final IndexCandidateUseCase indexCandidateUseCase;
    private final ShowCandidateUseCase showCandidateUseCase;
    private final DeleteCandidateUseCase deleteCandidateUseCase;

    private final CandidateMapper candidateMapper;
    private final ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<PageBaseDto<CandidateResponse>> index(
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        PageBase<Candidate> candidatePageBase = indexCandidateUseCase.index(page, size);
        List<CandidateResponse> content = objectMapper.convertValue(
                candidatePageBase.getContent(), new TypeReference<>() {
                }
        );
        PageBaseDto<CandidateResponse> candidateResponsePageBaseDto = PageBaseDto.<CandidateResponse>builder()
                .totalPages(candidatePageBase.getTotalPages())
                .page(page)
                .size(size)
                .totalElements(candidatePageBase.getTotalElements())
                .content(content)
                .empty(candidatePageBase.getEmpty())
                .build();
        return new ResponseEntity<>(candidateResponsePageBaseDto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CandidateResponse> create(@Validated(OnCreate.class) @RequestBody CandidateRequest request) {
        Candidate candidate = candidateMapper.toEntity(request);
        Candidate candidateEntitySaved = createCandidateUseCase.create(candidate);
        CandidateResponse candidateResponse = candidateMapper.toEntityResponse(candidateEntitySaved);
        return new ResponseEntity<>(candidateResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<CandidateResponse> update(@PathVariable UUID uuid, @RequestBody CandidateRequest request) {
        Candidate candidate = candidateMapper.updateModel(request, Candidate.builder().build());
        Candidate candidateEntitySaved = updateCandidateUseCase.update(uuid, candidate);
        CandidateResponse candidateResponse = candidateMapper.toEntityResponse(candidateEntitySaved);
        return new ResponseEntity<>(candidateResponse, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CandidateResponse> show(@PathVariable UUID uuid) {
        Candidate entity = showCandidateUseCase.show(uuid);
        CandidateResponse candidateResponse = candidateMapper.toEntityResponse(entity);
        return new ResponseEntity<>(candidateResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        deleteCandidateUseCase.delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
