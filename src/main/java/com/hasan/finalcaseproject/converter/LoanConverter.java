package com.hasan.finalcaseproject.converter;

import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.model.Loan;
import com.hasan.finalcaseproject.dto.request.LoanApplicationRequest;
import com.hasan.finalcaseproject.dto.response.LoanApplicationResponse;
import com.hasan.finalcaseproject.dto.request.LoanCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LoanConverter {
    public LoanApplicationResponse convertToDto(Loan loanToSave) {
        LoanApplicationResponse loanApplicationResponseDto = new LoanApplicationResponse();
        loanApplicationResponseDto.setLoanResult(loanToSave.getLoanResult());
        loanApplicationResponseDto.setLoanLimit(loanToSave.getLoanLimit());

        return loanApplicationResponseDto;
    }

    public LoanCreateRequest convertLoanCreateRequestToDto(Loan loanToSave) {
        LoanCreateRequest loanCreateRequestDto = new LoanCreateRequest();
        loanCreateRequestDto.setCustomerId(loanToSave.getId());
        loanCreateRequestDto.setLoanResult(loanToSave.getLoanResult());
        loanCreateRequestDto.setLoanLimit(loanToSave.getLoanLimit());

        return loanCreateRequestDto;
    }

    public Loan convertToEntityFromRequest(LoanApplicationRequest dto){
        Loan loan = new Loan();
        if (dto != null){
            BeanUtils.copyProperties(dto, loan);
        }
        return loan;
    }

    public Customer convertCustomerToEntityFromRequest(LoanApplicationRequest dto){
        Customer customer = new Customer();
        if (dto != null){
            BeanUtils.copyProperties(dto, customer);
        }
        return customer;
    }
}
