package net.simbatools.banking.service;

import net.simbatools.banking.dto.AccountDto;
import net.simbatools.banking.entity.Account;
import net.simbatools.banking.mepper.AccountMapper;
import net.simbatools.banking.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAcount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAcount);
    }
}
