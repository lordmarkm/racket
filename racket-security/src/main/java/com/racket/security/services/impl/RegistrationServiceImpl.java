package com.racket.security.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.baldy.commons.security.models.Account;
import com.baldy.commons.security.services.AccountService;
import com.baldy.commons.security.services.Roles;
import com.racket.security.services.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Resource
    private AccountService accounts;

    @Override
    public Account register(String username, String password) {

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setAuthorities(Roles.ROLE_USER);

        return accounts.save(account);
    }

}
