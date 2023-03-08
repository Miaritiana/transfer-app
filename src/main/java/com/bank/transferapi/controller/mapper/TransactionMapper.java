package com.bank.transferapi.controller.mapper;

import com.bank.transferapi.controller.response.TransactionResponse;
import com.bank.transferapi.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionResponse toRest(Transaction domain) {
        return TransactionResponse.builder()
                .date(domain.getDate())
                .Description(domain.getDescription())
                .customer(domain.getCustomer())
                .build();
    }

    public Transaction toDomain(TransactionResponse rest) {
        return Transaction.builder()
                .date(rest.getDate())
                .Description(rest.getDescription())
                .customer(rest.getCustomer())
                .build();
    }
}
