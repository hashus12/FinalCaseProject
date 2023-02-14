package com.hasan.finalcaseproject.repos;

import com.hasan.finalcaseproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Customer, Long> {
}
