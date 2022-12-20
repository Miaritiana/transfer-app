package com.example.banking.controller;

import com.example.banking.model.Customer;
import com.example.banking.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/Customers")
    public List<Customer> getAllCustomers(){
        return customerService.allCustomers();
    }
    @GetMapping("/Customer/{id_customer}")
    public Optional<Customer> getCustomerById(@PathVariable int id_customer){
        return customerService.findCustomerById(id_customer);
    }
    @DeleteMapping("/Customer/{id_customer}")
    public String deleteCustomerById(@PathVariable int id_customer){
        customerService.deleteCustomerById(id_customer);
        return "Customer deleted successfully";
    }
    @PostMapping("/Customers")
    public List<Customer> addCustomers(List<Customer> customerList){
        return customerService.addCustomers(customerList);
    }
    @PutMapping("/Customer/{id_customer}")
    public Customer putCustomer(@PathVariable int id_customer, Customer customer){
        return customerService.updateOneCustomer(id_customer, customer);
    }
    @PatchMapping("/Customer/{id_customer}")
    public Customer patchCustomer(@PathVariable int id_customer, Customer customer){
        return customerService.patchCustomer(id_customer, customer);
    }
}
