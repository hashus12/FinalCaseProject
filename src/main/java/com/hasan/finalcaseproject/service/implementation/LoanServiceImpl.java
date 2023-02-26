package com.hasan.finalcaseproject.service.implementation;

import com.hasan.finalcaseproject.exception.ServiceOperationException;
import com.hasan.finalcaseproject.model.Loan;
import com.hasan.finalcaseproject.repository.LoanRepository;
import com.hasan.finalcaseproject.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    public Loan saveOneLoan(Loan newLoan) {
        return loanRepository.save(newLoan);
    }

    public Loan findLoanbyId(Long customerId) {
        return loanRepository.findById(customerId).orElse(null);
    }

    public boolean checkCustomerHasLoanApplication(Long customerId) {
        Loan loan = loanRepository.findLoanByCustomerId(customerId);
        log.debug("Loan Id -> {} date: {} getting", customerId, new Date());
        if (loan != null) {
            return true;
        }
        return false;
    }

    public Loan findLoanByCustomerId(Long customerId) {
        Loan loan = loanRepository.findLoanByCustomerId(customerId);
        if (loan == null)
            throw new ServiceOperationException.NotFoundException("Loan not found");
        log.debug("Customer Id -> {} date: {} getting", customerId, new Date());
        return loan;
    }

    public Loan checkAndGetLoanByCustomerId(Long customerId) {
        Loan loan = loanRepository.findLoanByCustomerId(customerId);
        if (loan != null)
            throw new ServiceOperationException.AlreadyExistException("already exist a loan application ."+customerId);
        log.debug("Customer Id -> {} date: {} getting", customerId, new Date());
        return loan;
    }
}

