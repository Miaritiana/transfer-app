package com.bank.transferapi.controller.response;

import com.bank.transferapi.model.Customer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@EqualsAndHashCode
public class AccountResponse {
    private long idAccount;
    private CustomerResponse customer;
    private double balance;
}
