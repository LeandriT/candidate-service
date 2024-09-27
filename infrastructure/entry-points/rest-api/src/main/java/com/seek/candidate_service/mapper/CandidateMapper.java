package com.seek.candidate_service.mapper;


import com.seek.candidate_service.dto.candidate.request.CandidateRequest;
import com.seek.candidate_service.dto.candidate.response.CandidateResponse;
import entity.Candidate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CandidateMapper {

    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);

    Candidate toEntity(CandidateRequest request);

    @Mappings({})
    CandidateResponse toEntityResponse(Candidate candidate);

    Candidate updateModel(CandidateRequest request, @MappingTarget Candidate entity);
}
