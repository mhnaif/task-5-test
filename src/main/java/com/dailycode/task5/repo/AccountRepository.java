package com.dailycode.task5.repo;

import com.dailycode.task5.entity.Account;
import com.dailycode.task5.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account,Long> {


    @Query("select a from Customer c , Account a where 1=1 and a.customerId = c.customerId and c.customerNumber = :customerNumber ")
    List<Account> getAllAccountsByCustomerNumber(Long customerNumber);

    @Query("select a from Customer c , Account a where 1=1 and a.customerId = c.customerId and c.civilId = :civilId ")
    List<Account> getAllAccountsByCivilId(Long civilId);
}
