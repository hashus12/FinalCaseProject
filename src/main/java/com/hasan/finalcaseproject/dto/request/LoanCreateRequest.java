package com.hasan.finalcaseproject.dto.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class LoanCreateRequest {
    Long loanId;
    Long customerId;
    Boolean loanResult;
    Double loanLimit;
    Double loanScore;
}
