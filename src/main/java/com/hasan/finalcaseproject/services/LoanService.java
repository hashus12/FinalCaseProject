package com.hasan.finalcaseproject.services;

import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.model.Loan;
import com.hasan.finalcaseproject.repos.CustomerRepository;
import com.hasan.finalcaseproject.repos.LoanRepository;
import com.hasan.finalcaseproject.dto.request.LoanCreateRequest;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;

    }

    public Loan saveOneLoan(Loan newLoan) {
        return loanRepository.save(newLoan);
    }

    public Loan getOneLoanbyId(Long customerId) {
        return loanRepository.findById(customerId).orElse(null);
    }
}

