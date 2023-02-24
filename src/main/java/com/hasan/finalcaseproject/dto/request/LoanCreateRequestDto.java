package com.hasan.finalcaseproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanCreateRequestDto {
    @Min(1)
    @NotNull
    Long loanId;

    @Min(1)
    @NotNull
    Long customerId;

    @NotNull
    Boolean loanResult;

    @Min(0)
    Double loanLimit;

    @Min(0)
    Double loanScore;
}
