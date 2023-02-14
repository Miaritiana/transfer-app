package com.bank.transferapi.repository;

import com.bank.transferapi.model.Customer;
import com.bank.transferapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    public List<Transaction> findByCustomer(Customer customer);
}
