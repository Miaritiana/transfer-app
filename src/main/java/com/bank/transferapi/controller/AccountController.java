package com.bank.transferapi.controller;

import com.bank.transferapi.controller.mapper.AccountMapper;
import com.bank.transferapi.controller.response.AccountResponse;
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
    private final AccountMapper accountMapper;
    @GetMapping("/Accounts")
    public List<AccountResponse> getAllAccounts(){
        return accountService.getAllAccounts().stream()
                .map(accountMapper::toRest)
                .toList();
    }
    @GetMapping("/Account/{id_account}")
    public Optional<AccountResponse> getAccountById(@PathVariable int id_account){
        return accountService.getOneAccount(id_account).stream()
                .map(accountMapper::toRest)
                .findAny();
    }
    @GetMapping("Account/Customer/{nic_number}")
    public Optional<AccountResponse> getAccountByCustomer(@PathVariable long nic_number){
        return accountService.getAccountByCustomer(nic_number).stream()
                .map(accountMapper::toRest)
                .findAny();
    }
    @DeleteMapping("/Account/{id_account}")
    public String deleteAccountById(@PathVariable int id_account){
        accountService.deleteAccountById(id_account);
        return "Customer deleted successfully";
    }
    @PostMapping("/Accounts")
    public List<AccountResponse> addAccounts(@RequestBody List<Account> customerList){
        return accountService.addAccounts(customerList).stream()
                .map(accountMapper::toRest)
                .toList();
    }
    @PutMapping("/Account/{id_account}")
    public AccountResponse putAccount(@PathVariable int id_account, @RequestBody Account account){
        return accountMapper.toRest(accountService.putAccount(id_account, account));
    }
    @PatchMapping("/Account/{id_account}")
    public AccountResponse patchCustomer(@PathVariable int id_account, @RequestBody Account account){
        return accountMapper.toRest(accountService.patchAccount(id_account, account));
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
