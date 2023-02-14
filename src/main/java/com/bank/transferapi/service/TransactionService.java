package com.bank.transferapi.service;

import com.bank.transferapi.model.Customer;
import com.bank.transferapi.model.Transaction;
import com.bank.transferapi.repository.CustomerRepository;
import com.bank.transferapi.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    public List<Transaction> getAllTransactionByCustomer(long idCustomer){
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        return customer.map(transactionRepository::findByCustomer).orElse(null);
    }
    public List<Transaction> postTransaction(List<Transaction> transactions){
        return transactionRepository.saveAll(transactions);
    }
}
