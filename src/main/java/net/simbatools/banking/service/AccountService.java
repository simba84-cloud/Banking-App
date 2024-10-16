package net.simbatools.banking.service;

import net.simbatools.banking.dto.AccountDto;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto );
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id ,double amount);
}
