package com.hasan.finalcaseproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
@Data
public class Customer extends BaseModel{

    private String identityNumber;

    private String fullName;

    private Double monthlyIncome;

    private String phoneNumber;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "Europe/Istanbul",timezone = "tr-TR")
    private Date birthDate;

//    public Customer(){
//
//    }
//    public Customer(Long id, String identityNumber, String fullName, Double monthlyIncome, String phoneNumber, Date birthDate) {
//        this.id = id;
//        this.identityNumber = identityNumber;
//        this.fullName = fullName;
//        this.monthlyIncome = monthlyIncome;
//        this.phoneNumber = phoneNumber;
//        this.birthDate = birthDate;
//    }
}