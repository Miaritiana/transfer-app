package com.bank.transferapi.service;

import com.bank.transferapi.exception.BadRequestException;
import com.bank.transferapi.model.Account;
import com.bank.transferapi.model.Customer;
import com.bank.transferapi.repository.AccountRepository;
import com.bank.transferapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountByCustomer(long nicNumber){
        Optional<Customer> customer = customerRepository.findByNicNumber(nicNumber);
        return customer.map(accountRepository::findByCustomer).orElse(null);
    }
    public Optional<Account> getOneAccount(long id){
        return accountRepository.findById(id);
    }
    public void deleteAccountById(long id){
        accountRepository.deleteById(id);
    }
    public List<Account> addAccounts(List<Account> accounts){
        return accountRepository.saveAll(accounts);
    }
    public Account putAccount(long id, Account account){
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(optionalAccount.isPresent()){
            return accountRepository.save(account);
        } else {
            return null;
        }
    }
    public Account patchAccount(long id, Account account){
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            if(account.getCustomer() == null){
                optionalAccount.get().setCustomer(optionalAccount.get().getCustomer());
            } else {
                optionalAccount.get().setCustomer(account.getCustomer());
            }
            if(account.getBalance() == 0){
                optionalAccount.get().setBalance(optionalAccount.get().getBalance());
            } else {
                optionalAccount.get().setBalance(account.getBalance());
            }
            if(account.getCreationDate() == null){
                optionalAccount.get().setCreationDate(optionalAccount.get().getCreationDate());
            } else {
                optionalAccount.get().setCreationDate(account.getCreationDate());
            }
            return accountRepository.save(optionalAccount.get());
        } else {
            return null;
        }
    }

    public String credit(long id, double amount) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(optionalAccount.isPresent()){
            double balance = optionalAccount.get().getBalance();
            optionalAccount.get().setBalance(balance + amount);
        }
        return "Account credited successfully";
    }

    public String debit(long id, double amount) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(optionalAccount.isPresent()){
            double balance = optionalAccount.get().getBalance();
            if(balance > 0){
                optionalAccount.get().setBalance(balance - amount);
                accountRepository.save(optionalAccount.get());
                return "Account debited successfully";
            } else {
                throw new BadRequestException("You can not debit your account");
            }
        }
        return "Account debited successfully";
    }

    public String transfer(long id_sender, long id_receiver, double amount) {
        Optional<Account> sender = accountRepository.findById(id_sender);
        Optional<Account> receiver = accountRepository.findById(id_receiver);
        if (sender.isPresent() && receiver.isPresent()) {
            double senderBalance = sender.get().getBalance();
            double receiverBalance = receiver.get().getBalance();
            if(senderBalance>0){
                sender.get().setBalance(senderBalance - amount);
                receiver.get().setBalance(receiverBalance + amount);
            } else {
                throw new BadRequestException("You can not transfer money");
            }
        } else {
            throw new BadRequestException("Receiver does not exist");
        }
        return "Action completed successfully";
    }
}
