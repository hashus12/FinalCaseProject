package com.hasan.finalcaseproject.service.implementation;

import com.hasan.finalcaseproject.converter.CustomerConverter;
import com.hasan.finalcaseproject.dto.request.CreateCustomerDto;
import com.hasan.finalcaseproject.dto.request.UpdateCustomerDto;
import com.hasan.finalcaseproject.dto.response.CustomerResponseDto;
import com.hasan.finalcaseproject.exception.ServiceOperationException;
import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.repository.CustomerRepository;
import com.hasan.finalcaseproject.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;
    private final LoanServiceImpl loanServiceImpl;

    public List<CustomerResponseDto> getAllCustomers(int pageNumber, int pageSize) {
        Pageable paged = PageRequest.of(pageNumber, pageSize);
        List<CustomerResponseDto> customerResponseDtoList= customerRepository.findAll(paged)
                .stream()
                .map(customerConverter::convertEntityToResponseDto)
                .collect(Collectors.toList());
        log.debug("Customers get all date: {} getting", new Date());
        return customerResponseDtoList;
    }

    public Customer createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = customerRepository.save(customerConverter.convertRequestDtoToEntity(createCustomerDto));
        log.debug("Customer ID -> {} date: {} saved", customer.getId(), new Date());
        return customer;
    }

    public Customer saveCustomer(Customer createCustomer) {
        Customer customer = customerRepository.save(createCustomer);
        log.debug("Customer ID -> {} date: {} saved", customer.getId(), new Date());
        return customer;
    }


    public CustomerResponseDto findCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ServiceOperationException.NotFoundException("Customer could not find by id:"+customerId));
        log.debug("Customer ID -> {} date: {} getting", customerId, new Date());
        return customerConverter.convertEntityToResponseDto(customer);
    }

    public void updateCustomer(UpdateCustomerDto updateCustomerDto) {
        customerRepository.findById(updateCustomerDto.getId()).orElseThrow(() ->
                new ServiceOperationException.NotFoundException("Customer not found"));

        Customer customer = customerConverter.convertRequestDtoToEntity(updateCustomerDto);
        customerRepository.save(customer);
        log.debug("Customer ID -> {} date: {} updated", updateCustomerDto.getId(), new Date());
    }

    public void deleteCustomerById(Long customerId) {
        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new ServiceOperationException.NotFoundException("Customer not found"));

        if (loanServiceImpl.checkCustomerHasLoanApplication(customerId)) {
            throw new ServiceOperationException.CanNotDeletedException("You can not delete because customer has loan application");
        }
        customerRepository.deleteById(customerId);
        log.debug("Customer ID -> {} date: {} deleted", customer.getId(), new Date());
    }

    public Customer findByIdentityNumber(String identityNumber) {
        Customer customer = customerRepository.findByIdentityNumber(identityNumber);
        if (customer == null)
            throw new ServiceOperationException.NotFoundException("Customer not found");
        log.debug("Customer identity number -> {} date: {} getting", identityNumber, new Date());
        return customer;
    }

    public Customer getByIdentityNumber(String identityNumber) {
        Customer customer = customerRepository.findByIdentityNumber(identityNumber);
        if (customer != null)
            throw new ServiceOperationException.AlreadyExistException("Customer loan application already exist");
        log.debug("Customer identity number -> {} date: {} getting", identityNumber, new Date());
        return customer;
    }
}
