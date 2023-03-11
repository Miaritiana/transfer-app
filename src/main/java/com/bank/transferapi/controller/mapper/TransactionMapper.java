package com.bank.transferapi.controller.mapper;

import com.bank.transferapi.controller.response.TransactionResponse;
import com.bank.transferapi.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionMapper {

    private final CustomerMapper customerMapper;
    public TransactionResponse toRest(Transaction domain) {
        return TransactionResponse.builder()
                .date(domain.getDate())
                .Description(domain.getDescription())
                .customer(customerMapper.toRest(domain.getCustomer()))
                .build();
    }

    public Transaction toDomain(TransactionResponse rest) {
        return Transaction.builder()
                .date(rest.getDate())
                .Description(rest.getDescription())
                .customer(customerMapper.toDomain(rest.getCustomer()))
                .build();
    }
}
