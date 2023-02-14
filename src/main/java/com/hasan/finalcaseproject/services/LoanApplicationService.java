package com.hasan.finalcaseproject.services;

import com.hasan.finalcaseproject.converter.LoanConverter;
import com.hasan.finalcaseproject.repos.*;
import com.hasan.finalcaseproject.dto.request.LoanApplicationRequest;
import com.hasan.finalcaseproject.dto.response.LoanApplicationResponse;
import com.hasan.finalcaseproject.model.Collateral;
import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.model.Loan;
import com.hasan.finalcaseproject.util.generator.NumberGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoanApplicationService {
    private final CustomerService customerService;
    private final LoanService loanService;
    private final CollateralService collateralService;
    Double loanLimitMultiplier = 4.0;
    private final CustomerRepository customerRepository;

    public LoanApplicationResponse applyForLoan(LoanApplicationRequest request) {
        Customer customer = customerRepository.findByIdentityNumber(request.getIdentityNumber());
        if (customer != null) {
            return null;
            //mesaj zaten başvuru var.
        }
        if (customer == null) {
            customer = new Customer();
            customer.setFullName(request.getFullName());
            customer.setMonthlyIncome(request.getMonthlyIncome());
            customer.setIdentityNumber(request.getIdentityNumber());
            customer.setPhoneNumber(request.getPhoneNumber());
            customer.setBirthDate(request.getBirthDate());
            customerService.saveOneCustomer(customer);
        }
        return applyForLoanBussines(customer,request);
    }

    public LoanApplicationResponse applyForLoanBussines(Customer customer, LoanApplicationRequest request) {
        Collateral collateralToSave = new Collateral();
        Loan loanToSave = new Loan();
        collateralToSave.setCollateralIdentityno(request.getCollateralIdentityNo());
        collateralToSave.setCollateralValue(request.getCollateralValue());

        Double loanScore = NumberGenerator.randomNumber();
        if (loanScore < 500) {
            loanToSave.setLoanResult(false);
            loanToSave.setLoanLimit(null);
        } else if (500 < loanScore && loanScore < 1000 && customer.getMonthlyIncome() < 5000) {
            loanToSave.setLoanResult(true);
            loanToSave.setLoanLimit(10000.0);
            if (collateralToSave.getCollateralIdentityno() != null) {
                loanToSave.setLoanLimit(loanToSave.getLoanLimit() + collateralToSave.getCollateralValue() / 10);
            }
        } else if (500 < loanScore && loanScore < 1000
                && 5000 < customer.getMonthlyIncome() && customer.getMonthlyIncome() < 10000) {
            loanToSave.setLoanResult(true);
            loanToSave.setLoanLimit(20000.0);
            if (collateralToSave.getCollateralIdentityno() != null) {
                loanToSave.setLoanLimit(loanToSave.getLoanLimit() + collateralToSave.getCollateralValue() / 5);
            }
        } else if (500 < loanScore && loanScore < 1000
                && 10000 < customer.getMonthlyIncome()) {
            loanToSave.setLoanResult(true);
            loanToSave.setLoanLimit(customer.getMonthlyIncome() * loanLimitMultiplier / 2);
            if (collateralToSave.getCollateralIdentityno() != null) {
                loanToSave.setLoanLimit(loanToSave.getLoanLimit() + collateralToSave.getCollateralValue() / 4);
            }
        } else if (loanScore >= 1000) {
            loanToSave.setLoanResult(true);
            loanToSave.setLoanLimit(customer.getMonthlyIncome() * loanLimitMultiplier);
            if (collateralToSave.getCollateralIdentityno() != null) {
                loanToSave.setLoanLimit(loanToSave.getLoanLimit() + collateralToSave.getCollateralValue() / 2);
            }
        }

        loanToSave.setCustomer(customer);
        loanToSave.setCollateral(collateralToSave);


        collateralService.saveOneCollateral(collateralToSave);
        loanService.saveOneLoan(loanToSave);
        LoanApplicationResponse loanApplicationResponse = new LoanApplicationResponse();
        loanApplicationResponse.setLoanResult(loanToSave.getLoanResult());
        loanApplicationResponse.setLoanLimit(loanToSave.getLoanLimit());
        return loanApplicationResponse;
//                return loanConverter.convertToDto(loanService.createOneLoan(loanToSave));

    }
}
