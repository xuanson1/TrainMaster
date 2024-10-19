package com.example.springmvc.dao;

import com.example.springmvc.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRespository extends JpaRepository<Account,Integer> {
    public List<Account> findByAccountName(String accountName);
}
