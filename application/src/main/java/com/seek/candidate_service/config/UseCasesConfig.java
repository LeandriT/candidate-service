package com.seek.candidate_service.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.seek.candidate_service.domain.usecase",
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCaseImpl$"),
        useDefaultFilters = false
)
public class UseCasesConfig {
    // Puedes agregar más configuraciones si es necesario
}