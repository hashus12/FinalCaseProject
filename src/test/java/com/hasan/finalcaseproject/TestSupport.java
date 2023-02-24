package com.hasan.finalcaseproject;

import com.hasan.finalcaseproject.dto.request.CreateCustomerDto;
import com.hasan.finalcaseproject.dto.response.CustomerResponseDto;
import com.hasan.finalcaseproject.model.Customer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSupport {
    public static Date generateDate(){
//        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date date =new Date();
        return date;
    }
    public static Customer generateCustomer() {
        return new Customer(
                "identityNumber",
                "fullName",
                1.0,
                "phoneNumber",
                generateDate());
    }
    public static CustomerResponseDto generateCustomerResponseDto() {
        return new CustomerResponseDto(1L,
                "identityNumber",
                "fullName",
                1.0,
                "phoneNumber",
                generateDate());
    }

    public static CreateCustomerDto generateCreateCustomerDto() {
        return new CreateCustomerDto(
                "identityNumber",
                "fullName",
                1.0,
                "phoneNumber",
                generateDate());
    }

}
