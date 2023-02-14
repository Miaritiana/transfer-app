package com.bank.transferapi.controller;

import com.bank.transferapi.model.Account;

import com.bank.transferapi.service.AccountService;
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
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/Accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    @GetMapping("/Account/{id_account}")
    public Optional<Account> getAccountById(@PathVariable int id_account){
        return accountService.getOneAccount(id_account);
    }
    @GetMapping("Account/Customer/{nic_number}")
    public Optional<Account> getAccountByCustomer(@PathVariable long nic_number){
        return accountService.getAccountByCustomer(nic_number);
    }
    @DeleteMapping("/Account/{id_account}")
    public String deleteAccountById(@PathVariable int id_account){
        accountService.deleteAccountById(id_account);
        return "Customer deleted successfully";
    }
    @PostMapping("/Accounts")
    public List<Account> addAccounts(@RequestBody List<Account> customerList){
        return accountService.addAccounts(customerList);
    }
    @PutMapping("/Account/{id_account}")
    public Account putAccount(@PathVariable int id_account, @RequestBody Account account){
        return accountService.putAccount(id_account, account);
    }
    @PatchMapping("/Account/{id_account}")
    public Account patchCustomer(@PathVariable int id_account, @RequestBody Account account){
        return accountService.patchAccount(id_account, account);
    }
    @PostMapping("/Accounts/{id}/credit/{amount}")
    public String credit(@PathVariable long id, @PathVariable double amount){
        return accountService.credit(id, amount);
    }
    @PostMapping("/Accounts/{id}/debit/{amount}")
    public String debit(@PathVariable long id, @PathVariable double amount){
        return accountService.debit(id, amount);
    }
    @PostMapping("/Accounts/{id_sender}/Transfer/{amount}/To/{id_receiver}")
    public String transfer(@PathVariable long id_sender, @PathVariable long id_receiver, @PathVariable double amount){
        return accountService.transfer(id_sender, id_receiver, amount);
    }
}
