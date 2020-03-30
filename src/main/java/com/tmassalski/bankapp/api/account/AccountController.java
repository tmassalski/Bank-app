package com.tmassalski.bankapp.api.account;

import com.tmassalski.bankapp.domain.account.AccountFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
class AccountController {

    private final AccountFacade accountFacade;

    @PostMapping(path = "users/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    private void create(@PathVariable long userId){
        accountFacade.createAccountForUserId(userId);
    }
}
