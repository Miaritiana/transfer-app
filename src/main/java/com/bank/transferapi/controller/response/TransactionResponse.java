package com.bank.transferapi.controller.response;

import com.bank.transferapi.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@EqualsAndHashCode
public class TransactionResponse {
    private Date date;
    private String Description;
    private CustomerResponse customer;
}
