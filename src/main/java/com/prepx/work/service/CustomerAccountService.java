package com.prepx.work.service;


import com.prepx.work.entity.CustomerAccount;
import com.prepx.work.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerAccountService {

    private final CustomerAccountRepository repository;

    @Autowired
    public CustomerAccountService(CustomerAccountRepository repository) {
        this.repository = repository;
    }

    public Optional<CustomerAccount> getUserById(Long id) {
        return repository.findById(id);
    }

    public List<CustomerAccount> getAllUsersModifiedAfter(LocalDateTime lastModifiedDate) {
        return repository.findModifiedAfter(lastModifiedDate);
    }
}