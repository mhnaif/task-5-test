package com.dailycode.task5.service;


import com.dailycode.task5.Request.CustomerRequest;
import com.dailycode.task5.entity.Customer;
import com.dailycode.task5.repo.AccountRepository;
import com.dailycode.task5.repo.CustomerRepository;
import com.dailycode.task5.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerRequest request){
        Customer customer = new Customer();
        customer.setCustomerId(request.getCustomerId());
        customer.setCustomerNumber(request.getCustomerNumber());
        customer.setCivilId(request.getCivilId());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setFullName(request.getFullName());
        customer.setDateOfBirth(request.getDateOfBirth());


        Customer saved = customerRepository.save(customer);
        return getCustomerResponse(saved);

    }

    public CustomerResponse getCustomer(Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("customer not found"));
        return getCustomerResponse(customer);
    }

    private CustomerResponse getCustomerResponse(Customer saved) {
        CustomerResponse response = new CustomerResponse();
        response.setCustomerId(saved.getCustomerId());
        response.setCustomerNumber(saved.getCustomerNumber());
        response.setCivilId(saved.getCivilId());
        response.setFullName(saved.getFullName());
        response.setDateOfBirth(saved.getDateOfBirth());
        response.setMobileNumber(saved.getMobileNumber());
        return response;
    }


}
