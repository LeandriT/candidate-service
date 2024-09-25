package com.seek.candidate_service.dto.candidate.response;

import com.seek.candidate_service.dto.abstracts.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponse extends BaseDto {
    private String name;

    private String email;

    private String gender;

    private BigDecimal salaryExpected;

    private String phoneNumber;
    private String address;
}
