package com.seek.candidate_service.mapper;


import com.seek.candidate_service.entity.TokenEntity;
import entity.token.Token;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TokenMapperJpa {
    @Mapping(target = "uuid", ignore = true)
    TokenEntity toEntityJpa(Token token);

    @Mappings({})
    Token toEntityDomain(TokenEntity tokenEntity);
}
