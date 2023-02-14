package com.hasan.finalcaseproject.repos;

import com.hasan.finalcaseproject.model.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollateralRepository extends JpaRepository<Collateral, Long> {
}
