package com.hasan.finalcaseproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponseDto {
    private Long id;
    private String identityNumber;
    private String fullName;
    private Double monthlyIncome;
    private String phoneNumber;
    private Date birthDate;
}
