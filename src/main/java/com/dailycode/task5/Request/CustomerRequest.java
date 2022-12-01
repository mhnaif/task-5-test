package com.dailycode.task5.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private Long customerId;
    private Long customerNumber;
    private Long civilId;
    private LocalDate dateOfBirth;
    private String fullName;
    private String mobileNumber;
}
