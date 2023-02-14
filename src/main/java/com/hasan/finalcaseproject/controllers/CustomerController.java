package com.hasan.finalcaseproject.controllers;

import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer newCustomer){
        return customerService.saveOneCustomer(newCustomer);
    }

    @GetMapping("/{customerId}")
    public Customer getOneCustomer(@PathVariable Long customerId){
        //custom exception
        return customerService.getOneCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer updateOneCustomer(@PathVariable Long customerId ,@RequestBody Customer newCustomer){
        return customerService.updateOneCustomer(customerId, newCustomer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteOneCustomer(@PathVariable Long customerId){
        customerService.deleteById(customerId);
    }
}
