package com.seek.candidate_service;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@Log4j2
public class CandidateServiceApplication {

    public static void main(String[] args) {
        log.info("Starting application init");
        SpringApplication.run(CandidateServiceApplication.class, args);
        log.info("Starting application end");
    }
}