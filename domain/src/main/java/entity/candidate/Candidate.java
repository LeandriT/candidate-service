package entity.candidate;

import entity.abstracts.Base;
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
public class Candidate extends Base {

    private String name;

    private String email;

    private String gender;

    private BigDecimal salaryExpected;

    private String phoneNumber;
    private String address;
}
