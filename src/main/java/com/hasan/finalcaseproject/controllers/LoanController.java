package com.hasan.finalcaseproject.controllers;

import com.hasan.finalcaseproject.model.Loan;
import com.hasan.finalcaseproject.dto.request.LoanCreateRequest;
import com.hasan.finalcaseproject.services.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public Loan createOneLoan(@RequestBody Loan newLoan) {
        return loanService.saveOneLoan(newLoan);
    }
}
