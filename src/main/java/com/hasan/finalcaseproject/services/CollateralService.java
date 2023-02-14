package com.hasan.finalcaseproject.services;

import com.hasan.finalcaseproject.model.Collateral;
import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.repos.CollateralRepository;
import org.springframework.stereotype.Service;

@Service
public class CollateralService {

    private final CollateralRepository collateralRepository;

    public CollateralService(CollateralRepository collateralRepository) {
        this.collateralRepository = collateralRepository;
    }

    public Collateral saveOneCollateral(Collateral newCollateral) {
        return collateralRepository.save(newCollateral);
    }
}
