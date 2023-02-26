package com.hasan.finalcaseproject.converter;

import com.hasan.finalcaseproject.dto.request.CreateCustomerDto;
import com.hasan.finalcaseproject.dto.request.LoanApplicationRequestDto;
import com.hasan.finalcaseproject.dto.request.LoanCreateRequestDto;
import com.hasan.finalcaseproject.dto.request.UpdateCustomerDto;
import com.hasan.finalcaseproject.dto.response.CustomerResponseDto;
import com.hasan.finalcaseproject.dto.response.LoanApplicationResponseDto;
import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.model.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerConverter {
    public CustomerResponseDto convertEntityToResponseDto(Customer customer){
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setId(customer.getId());
        customerResponseDto.setIdentityNumber(customer.getIdentityNumber());
        customerResponseDto.setFullName(customer.getFullName());
        customerResponseDto.setPhoneNumber(customer.getPhoneNumber());
        customerResponseDto.setBirthDate(customer.getBirthDate());
        customerResponseDto.setMonthlyIncome(customer.getMonthlyIncome());

        return customerResponseDto;
    }

    public Customer convertRequestDtoToEntity(CreateCustomerDto dto) {
        Customer customer = new Customer();
        customer.setFullName(dto.getFullName());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setMonthlyIncome(dto.getMonthlyIncome());
        customer.setBirthDate(dto.getBirthDate());
        customer.setIdentityNumber(dto.getIdentityNumber());

        return customer;
    }

    public Customer convertRequestDtoToEntity(UpdateCustomerDto dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setFullName(dto.getFullName());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setMonthlyIncome(dto.getMonthlyIncome());
        customer.setBirthDate(dto.getBirthDate());
        customer.setIdentityNumber(dto.getIdentityNumber());

        return customer;
    }

}