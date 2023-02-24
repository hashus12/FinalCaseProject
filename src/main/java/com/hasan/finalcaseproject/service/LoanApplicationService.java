package com.hasan.finalcaseproject.service;

import com.hasan.finalcaseproject.dto.request.LoanApplicationRequestDto;
import com.hasan.finalcaseproject.dto.response.LoanApplicationResponseDto;
import com.hasan.finalcaseproject.model.Customer;

import java.util.Date;

public interface LoanApplicationService {
    LoanApplicationResponseDto createLoanApplication(LoanApplicationRequestDto request);
    LoanApplicationResponseDto findLoanByIdentityAndBirthDate(String identityNumber, Date birthDate);
    LoanApplicationResponseDto applyForLoanBussines(Customer customer, LoanApplicationRequestDto request);
}
