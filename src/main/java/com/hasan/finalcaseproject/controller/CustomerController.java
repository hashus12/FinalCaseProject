package com.hasan.finalcaseproject.controller;

import com.hasan.finalcaseproject.dto.request.CreateCustomerDto;
import com.hasan.finalcaseproject.dto.request.UpdateCustomerDto;
import com.hasan.finalcaseproject.dto.response.CustomerResponseDto;
import com.hasan.finalcaseproject.service.implementation.CustomerServiceImpl;
import com.hasan.finalcaseproject.util.constant.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerServiceImpl customerServiceImpl;

    @GetMapping( "/{pageSize}/{pageNumber}")
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers(@PathVariable int pageSize,
                                          @PathVariable int pageNumber){
        return ResponseEntity.ok(customerServiceImpl.getAllCustomers(pageSize, pageNumber));
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@Valid @RequestBody CreateCustomerDto createCustomerDto){
        customerServiceImpl.createCustomer(createCustomerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully.");
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> findCustomerById(@PathVariable Long customerId){
        return ResponseEntity.ok(customerServiceImpl.findCustomerById(customerId));
    }

    @PutMapping
    public ResponseEntity<MessageResponse> updateCustomer(@Valid @RequestBody UpdateCustomerDto updateCustomerDto){
        customerServiceImpl.updateCustomer(updateCustomerDto);
        return ResponseEntity.ok(new MessageResponse("Customer updated successfully!"));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<MessageResponse> deleteOneCustomer(@PathVariable Long customerId){
        customerServiceImpl.deleteCustomerById(customerId);
        return ResponseEntity.ok(new MessageResponse("Customer deleted successfully!"));
    }
}
