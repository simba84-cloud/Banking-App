package net.simbatools.banking.mepper;

import net.simbatools.banking.dto.AccountDto;
import net.simbatools.banking.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
Account account = new Account(
        accountDto.getId(),
        accountDto.getAccountHolderName(),
        accountDto.getBalance());
        return account;
    }
    public static AccountDto accountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
