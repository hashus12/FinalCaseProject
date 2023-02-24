package com.hasan.finalcaseproject.repository;

import com.hasan.finalcaseproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
    Customer findByIdentityNumber(String identityNumber);

}
