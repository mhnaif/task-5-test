package com.dailycode.task5.controller;

import com.dailycode.task5.Request.AccountRequest;
import com.dailycode.task5.Request.CustomerRequest;
import com.dailycode.task5.entity.Account;
import com.dailycode.task5.entity.Customer;
import com.dailycode.task5.response.AccountResponse;
import com.dailycode.task5.service.AccountService;
import com.dailycode.task5.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountResponse addAccount(@RequestBody AccountRequest request) {
        return accountService.addAccount(request);
    }

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @PutMapping("/{id}")
    public AccountResponse updateAccount(@PathVariable Long id, @RequestBody AccountRequest request) {
        return accountService.updateAccount(id, request);
    }

    @GetMapping("/{id}")
    public List<AccountResponse> getAllByCivilId(Long id) {
        return accountService.getAllByCivilId(id);
    }

}
