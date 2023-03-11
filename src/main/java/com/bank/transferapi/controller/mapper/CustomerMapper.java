package com.bank.transferapi.controller.mapper;

import com.bank.transferapi.controller.response.CustomerResponse;
import com.bank.transferapi.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerResponse toRest(Customer domain){
        return CustomerResponse.builder()
                .idCustomer(domain.getIdCustomer())
                .firstName(domain.getFirstName())
                .name(domain.getName())
                .phoneNumber(domain.getPhoneNumber())
                .username(domain.getUsername())
                .build();
    }

    public Customer toDomain(CustomerResponse rest){
        return Customer.builder()
                .idCustomer(rest.getIdCustomer())
                .firstName(rest.getFirstName())
                .name(rest.getName())
                .phoneNumber(rest.getPhoneNumber())
                .username(rest.getUsername())
                .build();
    }
}
