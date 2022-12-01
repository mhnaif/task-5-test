package com.dailycode.task5.response;


import com.dailycode.task5.constant.AccountType;
import com.dailycode.task5.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private Long accountId;
    private Long accountNumber;
    private String currency;
    private BigDecimal currentBalance;
    private BigDecimal previousBalance;
    private AccountType accountType;
    private CustomerResponse customer;
}
