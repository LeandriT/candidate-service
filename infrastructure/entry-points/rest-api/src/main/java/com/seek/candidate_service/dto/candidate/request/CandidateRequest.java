package com.seek.candidate_service.dto.candidate.request;

import com.seek.candidate_service.retentions.OnCreate;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRequest {
    @NotNull(message = "name cannot be null", groups = {OnCreate.class})
    private String name;
    @NotNull(message = "email cannot be null", groups = {OnCreate.class})
    private String email;

    @NotNull(message = "gender cannot be null", groups = {OnCreate.class})
    private String gender;

    @NotNull(message = "salaryExpected cannot be null", groups = {OnCreate.class})
    private BigDecimal salaryExpected;

    private String phoneNumber;
    private String address;
}
