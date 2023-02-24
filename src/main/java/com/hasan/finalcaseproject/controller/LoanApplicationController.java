package com.hasan.finalcaseproject.controller;

import com.hasan.finalcaseproject.dto.request.LoanApplicationRequestDto;
import com.hasan.finalcaseproject.dto.response.LoanApplicationResponseDto;
import com.hasan.finalcaseproject.service.implementation.CustomerServiceImpl;
import com.hasan.finalcaseproject.service.implementation.LoanApplicationServiceImpl;
import com.hasan.finalcaseproject.service.implementation.LoanServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/forms")
public class LoanApplicationController {
    private final LoanApplicationServiceImpl loanApplicationServiceImpl;
    private final CustomerServiceImpl customerServiceImpl;
    private final LoanServiceImpl loanServiceImpl;

    @PostMapping
    public ResponseEntity<LoanApplicationResponseDto> createLoanApplication(@Valid @RequestBody LoanApplicationRequestDto request) {
        return ResponseEntity.ok(loanApplicationServiceImpl.createLoanApplication(request));
    }

    @GetMapping
    public ResponseEntity<LoanApplicationResponseDto> findLoanByIdentityAndBirthDate(@PathVariable String identityNumber, @PathVariable Date birthDate){
        return ResponseEntity.ok(loanApplicationServiceImpl.findLoanByIdentityAndBirthDate(identityNumber, birthDate));
    }
}
