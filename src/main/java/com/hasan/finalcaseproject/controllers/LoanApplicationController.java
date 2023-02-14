package com.hasan.finalcaseproject.controllers;

import com.hasan.finalcaseproject.dto.request.LoanApplicationRequest;
import com.hasan.finalcaseproject.dto.response.LoanApplicationResponse;
import com.hasan.finalcaseproject.services.CustomerService;
import com.hasan.finalcaseproject.services.LoanApplicationService;
import com.hasan.finalcaseproject.services.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loanapplication")
public class LoanApplicationController {
    private LoanApplicationService loanApplicationService;
    private CustomerService customerService;
    private LoanService loanService;

    public LoanApplicationController(LoanApplicationService loanApplicationService, CustomerService customerService,
                                     LoanService loanService) {
        this.loanApplicationService = loanApplicationService;
        this.customerService = customerService;
        this.loanService = loanService;
    }

    @PostMapping
    public LoanApplicationResponse applyForLoan(@RequestBody LoanApplicationRequest request) {
        return loanApplicationService.applyForLoan(request);
    }
}
