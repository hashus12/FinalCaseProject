package com.hasan.finalcaseproject.service;

import com.hasan.finalcaseproject.model.Loan;

public interface LoanService {
    Loan saveOneLoan(Loan newLoan);
    Loan findLoanbyId(Long customerId);
    boolean checkCustomerHasLoanApplication(Long customerId);
    Loan findLoanByCustomerId(Long customerId);
    Loan checkAndGetLoanByCustomerId(Long customerId);
}
