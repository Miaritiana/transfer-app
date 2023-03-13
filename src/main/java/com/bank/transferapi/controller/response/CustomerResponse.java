package com.bank.transferapi.controller.response;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@EqualsAndHashCode
public class CustomerResponse {
    private long idCustomer;
    private String firstName;
    private String name;
    private String phoneNumber;
    private String username;
}
