package com.example.springmvc.service.interface_service;

import com.example.springmvc.entity.Account;
import com.example.springmvc.entity.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public List<Account> getAllAccounts();

    public List<Account> getAccountByName(String name);

    public Account addAccount(Account account);

    public Account updateAccount(Account account);

    public Account deleteAccountById(int id);

    public Optional<Account> getAccountById(int id);
}
