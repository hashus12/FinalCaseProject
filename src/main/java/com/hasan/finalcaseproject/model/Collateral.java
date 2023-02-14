package com.hasan.finalcaseproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "collateral")
@Data
public class Collateral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private Long collateralIdentityno;

    private Double collateralValue;

}
