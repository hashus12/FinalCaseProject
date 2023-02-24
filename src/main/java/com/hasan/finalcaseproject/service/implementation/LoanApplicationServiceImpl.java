package com.hasan.finalcaseproject.service.implementation;

import com.hasan.finalcaseproject.converter.CustomerConverter;
import com.hasan.finalcaseproject.converter.LoanConverter;
import com.hasan.finalcaseproject.exception.ServiceOperationException;
import com.hasan.finalcaseproject.dto.request.LoanApplicationRequestDto;
import com.hasan.finalcaseproject.dto.response.LoanApplicationResponseDto;
import com.hasan.finalcaseproject.model.Collateral;
import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.model.Loan;
import com.hasan.finalcaseproject.service.LoanApplicationService;
import com.hasan.finalcaseproject.util.generator.NumberGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
    private final CustomerServiceImpl customerServiceImpl;
    private final LoanServiceImpl loanServiceImpl;
    private final CollateralServiceImpl collateralServiceImpl;
    Double loanLimitMultiplier = 4.0;
    private final LoanConverter loanConverter;

    public LoanApplicationResponseDto createLoanApplication(LoanApplicationRequestDto request) {
        Customer customer = customerServiceImpl.getByIdentityNumber(request.getIdentityNumber());
        if (customer == null) {
            customer = new Customer();
            customer.setFullName(request.getFullName());
            customer.setMonthlyIncome(request.getMonthlyIncome());
            customer.setIdentityNumber(request.getIdentityNumber());
            customer.setPhoneNumber(request.getPhoneNumber());
            customer.setBirthDate(request.getBirthDate());

            customerServiceImpl.saveCustomer(customer);
        }

        return applyForLoanBussines(customer,request);
    }


    public LoanApplicationResponseDto applyForLoanBussines(Customer customer, LoanApplicationRequestDto request) {
        Collateral collateralToSave = new Collateral();
        Loan loanToSave = new Loan();
        collateralToSave.setCollateralIdentityno(request.getCollateralIdentityno());
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


        collateralServiceImpl.saveOneCollateral(collateralToSave);
        loanServiceImpl.saveOneLoan(loanToSave);
        return loanConverter.convertToDto(loanToSave);
//                return loanConverter.convertToDto(loanService.createOneLoan(loanToSave));
    }

    public LoanApplicationResponseDto findLoanByIdentityAndBirthDate(String identityNumber, Date birthDate) {
        Customer customer = customerServiceImpl.findByIdentityNumber(identityNumber);
        if (customer.getBirthDate() != birthDate){
            throw new ServiceOperationException.NotFoundException("birth date did not match.");
        }
        Loan loan = loanServiceImpl.findLoanByCustomerId(customer.getId());
        return loanConverter.convertToDto(loan);
    }
}
