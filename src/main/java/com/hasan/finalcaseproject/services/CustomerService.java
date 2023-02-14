package com.hasan.finalcaseproject.services;

import com.hasan.finalcaseproject.model.Customer;
import com.hasan.finalcaseproject.repos.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveOneCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    public Customer getOneCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public Customer updateOneCustomer(Long customerId, Customer newCustomer) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()){
            Customer foundCustomer = customer.get();
            foundCustomer.setFullName(newCustomer.getFullName());
            foundCustomer.setIdentityNumber(newCustomer.getIdentityNumber());
            foundCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
            foundCustomer.setBirthDate(newCustomer.getBirthDate());
            foundCustomer.setMonthlyIncome(newCustomer.getMonthlyIncome());
//            foundCustomer.setCollateralId(newCustomer.getCollateralId());
            customerRepository.save(foundCustomer);
            return foundCustomer;
        }else
            return null;
    }
    public void deleteById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

}
