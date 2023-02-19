package com.hasan.finalcaseproject.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateCustomerDto {
    private Long id;
    private String identityNumber;
    private String fullName;
    private Double monthlyIncome;
    private String phoneNumber;
    private Date birthDate;
}
