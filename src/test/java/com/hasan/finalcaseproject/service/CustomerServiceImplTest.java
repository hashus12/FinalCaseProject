package com.hasan.finalcaseproject.service;

import com.hasan.finalcaseproject.TestSupport;
import com.hasan.finalcaseproject.converter.CustomerConverter;
import com.hasan.finalcaseproject.dto.request.CreateCustomerDto;
import com.hasan.finalcaseproject.dto.response.CustomerResponseDto;
import com.hasan.finalcaseproject.exception.ServiceOperationException;
import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.repository.CustomerRepository;
import com.hasan.finalcaseproject.service.implementation.CustomerServiceImpl;
import com.hasan.finalcaseproject.service.implementation.LoanServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceImplTest extends TestSupport {
    private CustomerServiceImpl customerServiceImpl;
    private CustomerRepository customerRepository;
    private CustomerConverter customerConverter;
    private LoanServiceImpl loanServiceImpl;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        customerConverter = mock(CustomerConverter.class);
        loanServiceImpl = mock(LoanServiceImpl.class);
        customerServiceImpl = new CustomerServiceImpl(customerRepository, customerConverter, loanServiceImpl);
    }

    @Test
    public void testFindCustomerById_whenIdExists_shouldReturnCustomerResponseDto() {
        Customer customer = generateCustomer();
        CustomerResponseDto customerResponseDto = generateCustomerResponseDto();
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerConverter.convertEntityToResponseDto(customer)).thenReturn(customerResponseDto);

        CustomerResponseDto result = customerServiceImpl.findCustomerById(1L);

        assertEquals(result,
                customerResponseDto);

        verify(customerRepository).findById(1L);
        verify(customerConverter).convertEntityToResponseDto(customer);
    }

    @Test
    public void testFindCustomerById_whenIdDoesNotExists_shouldThrowCustomerNotFoundException() {
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ServiceOperationException.NotFoundException.class,
                () -> customerServiceImpl.findCustomerById(1L));
        Mockito.verifyNoInteractions(customerConverter);
    }

    @Test
    public void testCreateCustomer_whenCreateCustomerDtoExists_shouldSaveAndReturnCustomer() {
        Customer customer = generateCustomer();
        CreateCustomerDto createCustomerDto = generateCreateCustomerDto();

        when(customerConverter.convertRequestDtoToEntity(createCustomerDto)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = customerServiceImpl.createCustomer(createCustomerDto);

        assertEquals(result,
                customer);
    }
}