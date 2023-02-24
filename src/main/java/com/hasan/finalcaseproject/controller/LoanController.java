package com.hasan.finalcaseproject.controller;

import com.hasan.finalcaseproject.model.Loan;
import com.hasan.finalcaseproject.service.implementation.LoanServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {
    private LoanServiceImpl loanServiceImpl;

    public LoanController(LoanServiceImpl loanServiceImpl) {
        this.loanServiceImpl = loanServiceImpl;
    }

    @PostMapping
    public Loan createOneLoan(@Valid @RequestBody Loan newLoan) {
        return loanServiceImpl.saveOneLoan(newLoan);
    }
}
