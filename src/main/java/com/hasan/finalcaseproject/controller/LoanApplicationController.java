package com.hasan.finalcaseproject.controller;

import com.hasan.finalcaseproject.dto.request.LoanApplicationRequestDto;
import com.hasan.finalcaseproject.dto.response.LoanApplicationResponseDto;
import com.hasan.finalcaseproject.service.CustomerService;
import com.hasan.finalcaseproject.service.LoanApplicationService;
import com.hasan.finalcaseproject.service.LoanService;
import com.hasan.finalcaseproject.validator.implementation.EntityIdValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("/forms")
public class LoanApplicationController {
    private LoanApplicationService loanApplicationService;
    private CustomerService customerService;
    private LoanService loanService;
    private final EntityIdValidator entityIdValidator;

    @PostMapping
    public ResponseEntity<LoanApplicationResponseDto> applyForLoan(@RequestBody LoanApplicationRequestDto request) {
        return ResponseEntity.ok(loanApplicationService.applyForLoan(request));
    }

    @GetMapping
    public ResponseEntity<String> findLoanByIdentityAndBirthDate(@PathVariable String identityNumber, @PathVariable Date birthDate){
        return ResponseEntity.ok("");
    }
}
