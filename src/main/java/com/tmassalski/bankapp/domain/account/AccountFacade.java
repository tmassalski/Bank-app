package com.tmassalski.bankapp.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountFacade {

    private final AccountCreator accountCreator;

    public void createAccountForUserId(long userId) {
        accountCreator.createAccountAndAssignToUser(userId);
    }
}
