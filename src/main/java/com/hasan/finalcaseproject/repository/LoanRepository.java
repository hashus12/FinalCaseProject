package com.hasan.finalcaseproject.repository;

import com.hasan.finalcaseproject.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository <Loan, Long> {
    Loan findLoanByCustomerId(Long customerId);

}
