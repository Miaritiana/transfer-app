package com.bank.transferapi.controller;

import com.bank.transferapi.controller.mapper.TransactionMapper;
import com.bank.transferapi.controller.response.TransactionResponse;
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

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @GetMapping("Transaction/Customer/{id_customer}")
    public List<TransactionResponse> getTransactionByCustomer(@PathVariable long id_customer){
        return transactionService.getAllTransactionByCustomer(id_customer).stream()
                .map(transactionMapper::toRest)
                .toList();
    }
    @PostMapping("Transaction/")
    public List<TransactionResponse> addTransaction(@RequestBody List<Transaction> transactions){
        return transactionService.postTransaction(transactions).stream()
                .map(transactionMapper::toRest)
                .toList();
    }
}
