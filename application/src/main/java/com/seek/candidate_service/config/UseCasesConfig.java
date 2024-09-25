package com.seek.candidate_service.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // Indica que esta clase es una clase de configuración de Spring
@ComponentScan(
        basePackages = "com.seek.candidate_service.use_case", // Define el paquete base donde se buscarán los componentes
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCaseImpl$"), // Incluye solo las clases que terminan con 'UseCaseImpl'
        useDefaultFilters = false // Desactiva los filtros predeterminados de escaneo
)
public class UseCasesConfig {
    // Esta clase configura el escaneo de componentes para los casos de uso dentro del paquete 'com.seek.candidate_service.use_case'.
    // Se enfoca en incluir solo las implementaciones de los casos de uso que cumplen con el patrón especificado.
}