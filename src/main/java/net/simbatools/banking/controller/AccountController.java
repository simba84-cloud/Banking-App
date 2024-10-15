package net.simbatools.banking.controller;

import net.simbatools.banking.dto.AccountDto;
import net.simbatools.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //ADD ACCOUNT TO
    @PostMapping
    public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto){
      return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
}