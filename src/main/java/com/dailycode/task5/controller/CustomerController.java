package com.dailycode.task5.controller;

import com.dailycode.task5.Request.AccountRequest;
import com.dailycode.task5.Request.CustomerRequest;
import com.dailycode.task5.entity.Account;
import com.dailycode.task5.entity.Customer;
import com.dailycode.task5.response.CustomerResponse;
import com.dailycode.task5.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponse addCustomer(@RequestBody CustomerRequest request) {
        return customerService.addCustomer(request);
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }




}
