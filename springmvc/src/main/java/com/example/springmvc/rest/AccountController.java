package com.example.springmvc.rest;

import com.example.springmvc.entity.Account;
import com.example.springmvc.service.interface_service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/getAllAccount")
    public List<Account> getAllAccount(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/getAccountByName/{name}")
    public ResponseEntity<List<Account>> getAccountById(@PathVariable String name){
        List<Account> accounts = accountService.getAccountByName(name);
        if (!accounts.isEmpty()){
            return ResponseEntity.ok(accounts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        account.setAccountId(UUID.randomUUID().toString()); // bat buoc them moi va phat sinh ra id
        account = accountService.addAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PutMapping("/{name}")
    public ResponseEntity<Account> updateAccount(@PathVariable String name, @RequestBody Account account){
        List<Account> existingAccounts = accountService.getAccountByName(name);
        if (!existingAccounts.isEmpty()){
            Account existingAccount = existingAccounts.get(0);
            existingAccount.setPassword(account.getPassword());
            accountService.updateAccount(account);
            return ResponseEntity.ok(existingAccount);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteAccount(@PathVariable int id){
        Optional<Account> existingAccount = accountService.getAccountById(id);
        if (existingAccount.isPresent()){
            accountService.deleteAccountById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
