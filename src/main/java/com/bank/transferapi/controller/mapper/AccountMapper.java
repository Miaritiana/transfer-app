package com.bank.transferapi.controller.mapper;

import com.bank.transferapi.controller.response.AccountResponse;
import com.bank.transferapi.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountMapper {

    private final CustomerMapper customerMapper;
    public AccountResponse toRest(Account domain) {
        return AccountResponse.builder()
                .idAccount(domain.getIdAccount())
                .customer(customerMapper.toRest(domain.getCustomer()))
                .balance(domain.getBalance())
                .build();
    }

    public Account toDomain(AccountResponse rest) {
        return Account.builder()
                .idAccount(rest.getIdAccount())
                .customer(customerMapper.toDomain(rest.getCustomer()))
                .balance(rest.getBalance())
                .build();
    }
}
