package com.bank.transferapi.controller;

import com.bank.transferapi.model.Transaction;
import com.bank.transferapi.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("Transaction/Customer/{id_customer}")
    public List<Transaction> getTransactionByCustomer(@PathVariable long id_customer){
        return transactionService.getAllTransactionByCustomer(id_customer);
    }
    @PostMapping("Transaction/")
    public List<Transaction> addTransaction(@RequestBody List<Transaction> transactions){
        return transactionService.postTransaction(transactions);
    }
}
