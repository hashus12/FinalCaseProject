package com.hasan.finalcaseproject.repos;

import com.hasan.finalcaseproject.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository <Loan, Long> {
}
