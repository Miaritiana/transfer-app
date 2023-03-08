package com.bank.transferapi.controller.mapper;

import com.bank.transferapi.controller.response.AccountResponse;
import com.bank.transferapi.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountResponse toRest(Account domain) {
        return AccountResponse.builder()
                .idAccount(domain.getIdAccount())
                .customer(domain.getCustomer())
                .balance(domain.getBalance())
                .build();
    }

    public Account toDomain(AccountResponse rest) {
        return Account.builder()
                .idAccount(rest.getIdAccount())
                .customer(rest.getCustomer())
                .balance(rest.getBalance())
                .build();
    }
}
