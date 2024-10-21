package net.simbatools.banking.service.impl;

import net.simbatools.banking.dto.AccountDto;
import net.simbatools.banking.entity.Account;
import net.simbatools.banking.mepper.AccountMapper;
import net.simbatools.banking.repository.AccountRepository;
import net.simbatools.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
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

    @Override
    public AccountDto getAccountById(Long id) {
       Account account = accountRepository.findById(id)
               .orElseThrow(()->new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
       double total = account.getBalance() + amount; //get existing account and add amount
       account.setBalance(total);
       Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        if(account.getBalance() < amount){
            throw new RuntimeException("insufficient balance");
        }
        double total = account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
       List<Account>accounts = accountRepository.findAll();
       return accounts.stream().map(AccountMapper::mapToAccountDto)
               .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);
    }
}
