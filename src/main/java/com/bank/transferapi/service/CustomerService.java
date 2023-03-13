package com.bank.transferapi.service;

import com.bank.transferapi.model.Customer;
import com.bank.transferapi.repository.CustomerRepository;
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
    public Optional<Customer> findCustomerById(long id){
        return customerRepository.findById(id);
    }
    public void deleteCustomerById(long id){
        customerRepository.deleteById(id);
    }
    public Customer addCustomers(Customer customers){
        return customerRepository.save(customers);
    }
    public Customer updateOneCustomer(long id, Customer customer){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }
    public Optional<Customer> whoAmI(String nicNumber){
        return customerRepository.findByNicNumber(nicNumber);
    }
    public Customer patchCustomer(long id, Customer customer){
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
            if(customer.getPhoneNumber() == null){
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
            if(customer.getNicNumber() == null){
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
