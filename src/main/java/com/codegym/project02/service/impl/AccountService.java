package com.codegym.project02.service.impl;

import com.codegym.project02.model.Account;
import com.codegym.project02.repository.IAccountRepository;
import com.codegym.project02.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;
    @Override
    public Iterable<Account> findAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return iAccountRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iAccountRepository.deleteById(id);
    }
}
