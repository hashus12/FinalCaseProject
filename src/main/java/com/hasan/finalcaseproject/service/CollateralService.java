package com.hasan.finalcaseproject.service;

import com.hasan.finalcaseproject.model.Collateral;
import com.hasan.finalcaseproject.repository.CollateralRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class CollateralService {

    private final CollateralRepository collateralRepository;

    public Collateral saveOneCollateral(Collateral newCollateral) {
        return collateralRepository.save(newCollateral);
    }
}
