package com.hasan.finalcaseproject.service;

import com.hasan.finalcaseproject.model.Collateral;
import org.springframework.stereotype.Service;

@Service
public interface CollateralService {
    Collateral saveOneCollateral(Collateral newCollateral);
}
