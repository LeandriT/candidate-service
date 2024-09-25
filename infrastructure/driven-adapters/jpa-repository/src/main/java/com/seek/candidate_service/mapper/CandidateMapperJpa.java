package com.seek.candidate_service.mapper;


import com.seek.candidate_service.entity.CandidateEntity;
import entity.Candidate;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CandidateMapperJpa {
    @Mapping(target = "uuid", ignore = true)
    CandidateEntity toEntityJpa(Candidate candidate);

    @Mappings({})
    Candidate toEntityDomain(CandidateEntity candidateEntity);

    CandidateEntity updateModel(Candidate candidate, @MappingTarget CandidateEntity candidateEntity);
}
