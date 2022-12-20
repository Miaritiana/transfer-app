package com.example.banking.service;

import com.example.banking.model.Customer;
import com.example.banking.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }
    public Optional<Customer> findCustomerById(int id){
        return customerRepository.findById(id);
    }
    public void deleteCustomerById(int id){
        customerRepository.deleteById(id);
    }
    public List<Customer> addCustomers(List<Customer> customers){
        return customerRepository.saveAll(customers);
    }
    public Customer updateOneCustomer(int id, Customer customer){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            optionalCustomer.get().setFirstName(customer.getFirstName());
            optionalCustomer.get().setName(customer.getName());
            optionalCustomer.get().setPhoneNumber(customer.getPhoneNumber());
            optionalCustomer.get().setAddress(customer.getAddress());
            optionalCustomer.get().setBirthday(customer.getBirthday());
            optionalCustomer.get().setNicNumber(customer.getNicNumber());
            return customerRepository.save(optionalCustomer.get());
        } else {
            return null;
        }
    }
    public Customer patchCustomer(int id, Customer customer){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            if(customer.getFirstName() == null){
                optionalCustomer.get().setFirstName(optionalCustomer.get().getFirstName());
            } else {
                optionalCustomer.get().setFirstName(customer.getFirstName());
            }
            if(customer.getName() == null){
                optionalCustomer.get().setName(optionalCustomer.get().getName());
            } else {
                optionalCustomer.get().setName(customer.getName());
            }
            if(customer.getPhoneNumber() == 0){
                optionalCustomer.get().setPhoneNumber(optionalCustomer.get().getPhoneNumber());
            } else {
                optionalCustomer.get().setPhoneNumber(customer.getPhoneNumber());
            }
            if(customer.getAddress() == null){
                optionalCustomer.get().setAddress(optionalCustomer.get().getAddress());
            } else {
                optionalCustomer.get().setAddress(customer.getAddress());
            }
            if(customer.getBirthday() == null){
                optionalCustomer.get().setBirthday(optionalCustomer.get().getBirthday());
            } else {
                optionalCustomer.get().setBirthday(customer.getBirthday());
            }
            if(customer.getNicNumber() == 0){
                optionalCustomer.get().setNicNumber(optionalCustomer.get().getNicNumber());
            } else {
                optionalCustomer.get().setNicNumber(customer.getNicNumber());
            }
            return customerRepository.save(optionalCustomer.get());
        } else {
            return null;
        }
    }
}
