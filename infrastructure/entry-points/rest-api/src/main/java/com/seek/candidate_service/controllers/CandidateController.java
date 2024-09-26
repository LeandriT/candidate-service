package com.seek.candidate_service.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seek.candidate_service.dto.abstracts.PageBaseDto;
import com.seek.candidate_service.dto.candidate.request.CandidateRequest;
import com.seek.candidate_service.dto.candidate.response.CandidateResponse;
import com.seek.candidate_service.mapper.CandidateMapper;
import com.seek.candidate_service.retentions.OnCreate;
import com.seek.candidate_service.use_case.candidate.*;
import entity.abstracts.PageBase;
import entity.candidate.Candidate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "CandidateController Controller", description = "Operaciones relacionadas con candidatos")
public class CandidateController {
    private final CreateCandidateUseCase createCandidateUseCase;
    private final UpdateCandidateUseCase updateCandidateUseCase;
    private final IndexCandidateUseCase indexCandidateUseCase;
    private final ShowCandidateUseCase showCandidateUseCase;
    private final DeleteCandidateUseCase deleteCandidateUseCase;

    private final CandidateMapper candidateMapper;
    private final ObjectMapper objectMapper;

    @GetMapping
    @Operation(summary = "Obtener lista de candidatos paginados",
            description = "Obtiene una lista paginada de candidatos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de candidatos obtenida correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<PageBaseDto<CandidateResponse>> index(
            @Parameter(description = "Número de página a obtener", required = true, example = "0")
            @RequestParam Integer page,
            @Parameter(description = "Número de elementos por página", required = true, example = "10")
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
    @Operation(summary = "Crear candidato",
            description = "Crea un nuevo candidato y devuelve la respuesta con los detalles del candidato creado.")

    public ResponseEntity<CandidateResponse> create(
            @Validated(OnCreate.class)
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Detalles del candidato a crear", required = true)
            @RequestBody CandidateRequest request
    ) {
        Candidate candidate = candidateMapper.toEntity(request);
        Candidate candidateEntitySaved = createCandidateUseCase.create(candidate);
        CandidateResponse candidateResponse = candidateMapper.toEntityResponse(candidateEntitySaved);
        return new ResponseEntity<>(candidateResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    @Operation(summary = "Actualizar candidato",
            description = "Actualiza un candidato existente y devuelve la respuesta con los detalles del candidato actualizado.")
    public ResponseEntity<CandidateResponse> update(
            @Parameter(description = "UUID del candidato a actualizar", required = true)
            @PathVariable UUID uuid,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Detalles del candidato a actualizar", required = true)
            @RequestBody CandidateRequest request) {
        Candidate candidate = candidateMapper.updateModel(request, Candidate.builder().build());
        Candidate candidateEntitySaved = updateCandidateUseCase.update(uuid, candidate);
        CandidateResponse candidateResponse = candidateMapper.toEntityResponse(candidateEntitySaved);
        return new ResponseEntity<>(candidateResponse, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Obtener candidato por UUID",
            description = "Devuelve los detalles de un candidato específico utilizando su UUID.")
    public ResponseEntity<CandidateResponse> show(
            @Parameter(description = "UUID del candidato a obtener", required = true)
            @PathVariable UUID uuid) {
        Candidate entity = showCandidateUseCase.show(uuid);
        CandidateResponse candidateResponse = candidateMapper.toEntityResponse(entity);
        return new ResponseEntity<>(candidateResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Eliminar candidato por UUID",
            description = "Elimina un candidato específico utilizando su UUID.")
    public ResponseEntity<Void> delete(
            @Parameter(description = "UUID del candidato a eliminar", required = true)
            @PathVariable UUID uuid) {
        deleteCandidateUseCase.delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
