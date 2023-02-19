package com.hasan.finalcaseproject.service;

import com.hasan.finalcaseproject.model.Loan;
import com.hasan.finalcaseproject.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoanService {
    private final LoanRepository loanRepository;

    public Loan saveOneLoan(Loan newLoan) {
        return loanRepository.save(newLoan);
    }

    public Loan getOneLoanbyId(Long customerId) {
        return loanRepository.findById(customerId).orElse(null);
    }

    public boolean checkCustomerHasLoanApplication(Long customerId) {
        Loan loan = loanRepository.getLoanByCustomer_Id(customerId);
        if (loan != null) {
            return true;
        }
        return false;
    }
}

