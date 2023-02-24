package com.hasan.finalcaseproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerDto {
    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String identityNumber;

    @NotNull
    @NotBlank
    private String fullName;

    @NotNull
    @Min(0)
    private Double monthlyIncome;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 10)
    private String phoneNumber;

    @NotNull
    private Date birthDate;
}
