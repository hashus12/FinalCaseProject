package com.hasan.finalcaseproject.controller;

import com.hasan.finalcaseproject.dto.request.CreateCustomerDto;
import com.hasan.finalcaseproject.dto.request.UpdateCustomerDto;
import com.hasan.finalcaseproject.dto.response.CustomerResponseDto;
import com.hasan.finalcaseproject.service.CustomerService;
import com.hasan.finalcaseproject.util.constant.MessageResponse;
import com.hasan.finalcaseproject.validator.implementation.EntityIdValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final EntityIdValidator entityIdValidator;

    @GetMapping( "/{pageSize}/{pageNumber}")
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers(@PathVariable int pageSize,
                                          @PathVariable int pageNumber){
        return ResponseEntity.ok(customerService.getAllCustomers(pageSize, pageNumber));
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody CreateCustomerDto createCustomerDto){
        customerService.createCustomer(createCustomerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully.");
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long customerId){
        entityIdValidator.validate(customerId, "customer");
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @PutMapping
    public ResponseEntity<MessageResponse> updateCustomer(@RequestBody UpdateCustomerDto updateCustomerDto){
        entityIdValidator.validate(updateCustomerDto.getId(), "customer");
        customerService.updateCustomer(updateCustomerDto);
        return ResponseEntity.ok(new MessageResponse("Customer updated successfully!"));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<MessageResponse> deleteOneCustomer(@PathVariable Long customerId){
        entityIdValidator.validate(customerId, "customer");
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.ok(new MessageResponse("Customer deleted successfully!"));
    }
}
