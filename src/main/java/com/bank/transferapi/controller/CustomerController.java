package com.bank.transferapi.controller;

import com.bank.transferapi.controller.mapper.CustomerMapper;
import com.bank.transferapi.controller.response.CustomerResponse;
import com.bank.transferapi.model.Customer;
import com.bank.transferapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    @GetMapping("/Customers")
    public List<CustomerResponse> getAllCustomers(){
        return customerService.allCustomers().stream()
                .map(customerMapper::toRest)
                .toList();
    }
    @GetMapping("/Customer/{id_customer}")
    public Optional<CustomerResponse> getCustomerById(@PathVariable int id_customer){
        return customerService.findCustomerById(id_customer).stream()
                .map(customerMapper::toRest)
                .findAny();
    }
    @GetMapping("WhoAmI/{nic_number}")
    public Optional<CustomerResponse> woAmI(@PathVariable Long nic_number){
        return customerService.whoAmI(nic_number).stream()
                .map(customerMapper::toRest)
                .findAny();
    }
    @DeleteMapping("/Customer/{id_customer}")
    public String deleteCustomerById(@PathVariable int id_customer){
        customerService.deleteCustomerById(id_customer);
        return "Customer deleted successfully";
    }
    @PostMapping("/Customers")
    public CustomerResponse addCustomers(@RequestBody Customer customer){
        return customerMapper.toRest(customerService.addCustomers(customer));
    }
    @PutMapping("/Customer/{id_customer}")
    public CustomerResponse putCustomer(@PathVariable int id_customer,@RequestBody Customer customer){
        return customerMapper.toRest(customerService.updateOneCustomer(id_customer, customer));
    }
    @PatchMapping("/Customer/{id_customer}")
    public CustomerResponse patchCustomer(@PathVariable int id_customer,@RequestBody Customer customer){
        return customerMapper.toRest(customerService.patchCustomer(id_customer, customer));
    }
}
