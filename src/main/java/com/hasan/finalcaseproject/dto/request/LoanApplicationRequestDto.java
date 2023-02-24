package com.hasan.finalcaseproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanApplicationRequestDto {

    @NotBlank
    @NotNull
    @Size(min = 11, max = 11)
    String identityNumber;

    @NotBlank
    @NotNull
    String fullName;

    @Min(0)
    @NotNull
    Double monthlyIncome;

    @NotBlank
    @NotNull
    @Size(min = 10, max = 10)
    String phoneNumber;

    @NotNull
    Date birthDate;

    @Min(1)
    Long collateralIdentityno;

    @Min(0)
    Double collateralValue;
}
