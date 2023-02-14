package com.hasan.finalcaseproject.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanApplicationRequest {
    String identityNumber;
    String fullName;
    Double monthlyIncome;
    String phoneNumber;
    LocalDate birthDate;
    Long collateralIdentityNo;
    Double collateralValue;
}
