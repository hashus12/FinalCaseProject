package com.hasan.finalcaseproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanApplicationResponseDto {
    Boolean loanResult;
    Double loanLimit;
}
