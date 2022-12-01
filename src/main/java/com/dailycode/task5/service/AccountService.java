package com.dailycode.task5.service;


import com.dailycode.task5.Request.AccountRequest;
import com.dailycode.task5.entity.Account;
import com.dailycode.task5.entity.Customer;
import com.dailycode.task5.repo.AccountRepository;
import com.dailycode.task5.repo.CustomerRepository;
import com.dailycode.task5.response.AccountBalanceResponse;
import com.dailycode.task5.response.AccountResponse;
import com.dailycode.task5.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountResponse addAccount(AccountRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        Account account = new Account();
        account.setAccountId(request.getAccountId());
        account.setAccountType(request.getAccountType());
        account.setAccountNumber(request.getAccountNumber());
        account.setCurrency(request.getCurrency());
        account.setCurrentBalance(request.getCurrentBalance());
        account.setPreviousBalance(request.getPreviousBalance());
        account.setCustomer(customer);
        Account saved = accountRepository.save(account);

        Customer customer1 = saved.getCustomer();
        return getResponse(saved, customer1);

    }

    public AccountResponse getAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
        Customer customer = account.getCustomer();
        return getResponse(account, customer);
    }

    public AccountResponse updateAccount(Long id, AccountRequest request) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        account.setAccountId(request.getAccountId());
        account.setAccountType(request.getAccountType());
        account.setAccountNumber(request.getAccountNumber());
        account.setCurrency(request.getCurrency());
        account.setCurrentBalance(request.getCurrentBalance());
        account.setPreviousBalance(request.getPreviousBalance());
        account.setCustomer(customer);


        Account saved = accountRepository.save(account);

        Customer customer1 = saved.getCustomer();

        return getResponse(saved, customer1);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public AccountBalanceResponse getAccountBalance(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
        
        AccountBalanceResponse response = new AccountBalanceResponse();
        response.setCurrentBalance(account.getCurrentBalance());
        response.setPreviousBalance(account.getPreviousBalance());

        return response;

    }

    private AccountResponse getResponse(Account saved, Customer customer1) {
        AccountResponse response = new AccountResponse();
        response.setAccountId(saved.getAccountId());
        response.setAccountType(saved.getAccountType());
        response.setAccountNumber(saved.getAccountNumber());
        response.setCurrency(saved.getCurrency());
        response.setCurrentBalance(saved.getCurrentBalance());
        response.setPreviousBalance(saved.getPreviousBalance());

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerId(customer1.getCustomerId());
        customerResponse.setDateOfBirth(customer1.getDateOfBirth());
        customerResponse.setCustomerNumber(customer1.getCustomerNumber());
        customerResponse.setFullName(customer1.getFullName());
        customerResponse.setCivilId(customer1.getCivilId());


        return response;
    }

}
