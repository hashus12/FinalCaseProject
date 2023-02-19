package com.hasan.finalcaseproject.converter;

import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.model.Loan;
import com.hasan.finalcaseproject.dto.request.LoanApplicationRequestDto;
import com.hasan.finalcaseproject.dto.response.LoanApplicationResponseDto;
import com.hasan.finalcaseproject.dto.request.LoanCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LoanConverter {
    public LoanApplicationResponseDto convertToDto(Loan loan) {
        LoanApplicationResponseDto loanApplicationResponseDto = new LoanApplicationResponseDto();
        loanApplicationResponseDto.setLoanResult(loan.getLoanResult());
        loanApplicationResponseDto.setLoanLimit(loan.getLoanLimit());

        return loanApplicationResponseDto;
    }

    public LoanCreateRequestDto convertLoanCreateRequestToDto(Loan loanToSave) {
        LoanCreateRequestDto loanCreateRequestDto = new LoanCreateRequestDto();
        loanCreateRequestDto.setCustomerId(loanToSave.getId());
        loanCreateRequestDto.setLoanResult(loanToSave.getLoanResult());
        loanCreateRequestDto.setLoanLimit(loanToSave.getLoanLimit());

        return loanCreateRequestDto;
    }

    public Loan convertToEntityFromRequest(LoanApplicationRequestDto dto){
        Loan loan = new Loan();
        if (dto != null){
            BeanUtils.copyProperties(dto, loan);
        }
        return loan;
    }

    public Customer convertCustomerToEntityFromRequest(LoanApplicationRequestDto dto){
        Customer customer = new Customer();
        if (dto != null){
            BeanUtils.copyProperties(dto, customer);
        }
        return customer;
    }
}
