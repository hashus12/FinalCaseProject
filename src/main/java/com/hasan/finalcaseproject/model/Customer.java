package com.hasan.finalcaseproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
@Data
public class Customer extends BaseModel{

    private String identityNumber;

    private String fullName;

    private Double monthlyIncome;

    private String phoneNumber;

    private Date birthDate;
}