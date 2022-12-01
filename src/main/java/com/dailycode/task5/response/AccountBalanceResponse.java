package com.dailycode.task5.response;


import com.dailycode.task5.constant.AccountType;
import com.dailycode.task5.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountBalanceResponse {
    private BigDecimal currentBalance;
    private BigDecimal previousBalance;
}
