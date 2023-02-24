package com.hasan.finalcaseproject.service;

import com.hasan.finalcaseproject.dto.request.CreateCustomerDto;
import com.hasan.finalcaseproject.dto.request.UpdateCustomerDto;
import com.hasan.finalcaseproject.dto.response.CustomerResponseDto;
import com.hasan.finalcaseproject.model.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAllCustomers(int pageNumber, int pageSize);
    Customer createCustomer(CreateCustomerDto createCustomerDto);
    void updateCustomer(UpdateCustomerDto updateCustomerDto);
    void deleteCustomerById(Long customerId);
    CustomerResponseDto findCustomerById(Long customerId);
    Customer findByIdentityNumber(String identityNumber);
    Customer getByIdentityNumber(String identityNumber);
}
