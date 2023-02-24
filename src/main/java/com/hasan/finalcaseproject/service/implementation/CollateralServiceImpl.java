package com.hasan.finalcaseproject.service.implementation;

import com.hasan.finalcaseproject.model.Collateral;
import com.hasan.finalcaseproject.repository.CollateralRepository;
import com.hasan.finalcaseproject.service.CollateralService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class CollateralServiceImpl implements CollateralService {

    private final CollateralRepository collateralRepository;
    
    public Collateral saveOneCollateral(Collateral newCollateral) {
        Collateral collateral = collateralRepository.save(newCollateral);
        log.info("Collateral Id -> {} date: {} getting", newCollateral.getId(), new Date());
        return collateral;
    }
}
