package net.simbatools.banking.service;

import net.simbatools.banking.dto.AccountDto;
import net.simbatools.banking.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        return null;
    }
}
