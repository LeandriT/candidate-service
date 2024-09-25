package com.seek.candidate_service.model;

import com.seek.candidate_service.model.abstracts.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "candidates")
@SQLDelete(sql = "UPDATE candidates SET is_deleted = true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends BaseModel {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Gender cannot be null")
    private String gender;

    @NotNull(message = "Expected salary cannot be null")
    private BigDecimal salaryExpected;

    private String phoneNumber;
    private String address;
}
