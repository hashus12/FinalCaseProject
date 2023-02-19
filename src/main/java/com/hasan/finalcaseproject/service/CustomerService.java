package com.hasan.finalcaseproject.service;

import com.hasan.finalcaseproject.converter.CustomerConverter;
import com.hasan.finalcaseproject.dto.request.CreateCustomerDto;
import com.hasan.finalcaseproject.dto.request.UpdateCustomerDto;
import com.hasan.finalcaseproject.dto.response.CustomerResponseDto;
import com.hasan.finalcaseproject.exception.ServiceOperationException;
import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;
    private final LoanService loanService;

    public List<CustomerResponseDto> getAllCustomers(int pageNumber, int pageSize) {
        Pageable paged = PageRequest.of(pageNumber, pageSize);
        return customerRepository.findAll(paged)
                .stream()
                .map(customerConverter::convertEntityToResponseDto)
                .collect(Collectors.toList());
//        return customerRepository.findAll();
    }

    public Customer createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = customerRepository.save(customerConverter.convertRequestDtoToEntity(createCustomerDto));
        log.info("Customer ID -> {} date: {} saved", customer.getId(), new Date());
        return customer;
    }

    public CustomerResponseDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ServiceOperationException.NotFoundException("Customer not found"));
        log.info("Customer ID -> {} date: {} getting", customerId, new Date());
        return customerConverter.convertEntityToResponseDto(customer);
    }

    public void updateCustomer(UpdateCustomerDto updateCustomerDto) {
        customerRepository.findById(updateCustomerDto.getId()).orElseThrow(() ->
                new ServiceOperationException.NotFoundException("Customer not found"));

        Customer customer = customerConverter.convertRequestDtoToEntity(updateCustomerDto);
        customerRepository.save(customer);
        log.info("Customer ID -> {} date: {} updated", updateCustomerDto.getId(), new Date());
    }

    public void deleteCustomerById(Long customerId) {
        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new ServiceOperationException.NotFoundException("Customer not found"));

        if (loanService.checkCustomerHasLoanApplication(customerId)) {
            throw new ServiceOperationException.CanNotDeletedException("You can not delete because customer has loan application");
        }
        customerRepository.deleteById(customerId);
        log.info("Customer ID -> {} date: {} deleted", customer.getId(), new Date());
    }

    public Customer findByIdentityNumber(String identityNumber) {
        Customer customer = customerRepository.findByIdentityNumber(identityNumber);
        if (customer == null)
            throw new ServiceOperationException.NotFoundException("Customer not found");
        log.info("Customer identity number -> {} date: {} getting", identityNumber, new Date());
        return customer;
    }
}
