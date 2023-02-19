package com.hasan.finalcaseproject.dto.request;

import lombok.Data;

@Data
public class LoanCreateRequestDto {
    Long loanId;
    Long customerId;
    Boolean loanResult;
    Double loanLimit;
    Double loanScore;
}
