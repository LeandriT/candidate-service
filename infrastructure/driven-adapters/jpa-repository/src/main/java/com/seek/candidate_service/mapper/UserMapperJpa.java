package com.seek.candidate_service.mapper;


import com.seek.candidate_service.entity.UserEntity;
import entity.user.User;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapperJpa {
    @Mapping(target = "uuid", ignore = true)
    UserEntity toEntityJpa(User user);

    @Mappings({})
    User toEntityDomain(UserEntity userEntity);
}
