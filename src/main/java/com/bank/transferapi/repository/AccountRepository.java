package com.bank.transferapi.repository;

import com.bank.transferapi.model.Account;
import com.bank.transferapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public Optional<Account> findByCustomer(Customer customer);
}
