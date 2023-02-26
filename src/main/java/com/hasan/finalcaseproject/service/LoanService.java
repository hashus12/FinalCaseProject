package com.hasan.finalcaseproject.service;

import com.hasan.finalcaseproject.model.Loan;
import org.springframework.stereotype.Service;

@Service
public interface LoanService {
    Loan saveOneLoan(Loan newLoan);
    boolean checkCustomerHasLoanApplication(Long customerId);
    Loan findLoanByCustomerId(Long customerId);

}
