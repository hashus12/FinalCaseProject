package com.hasan.finalcaseproject.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class LoanApplicationRequestDto {
    String identityNumber;
    String fullName;
    Double monthlyIncome;
    String phoneNumber;
    Date birthDate;
    Long collateralIdentityno;
    Double collateralValue;
}
