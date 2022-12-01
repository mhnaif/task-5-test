package com.dailycode.task5.repo;

import com.dailycode.task5.entity.Account;
import com.dailycode.task5.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
