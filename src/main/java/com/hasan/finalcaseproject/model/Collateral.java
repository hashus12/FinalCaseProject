package com.hasan.finalcaseproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "collateral")
@Data
public class Collateral extends BaseModel{

    private Long collateralIdentityno;

    private Double collateralValue;
}
