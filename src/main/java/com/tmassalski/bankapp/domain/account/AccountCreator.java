package com.tmassalski.bankapp.domain.account;

import com.tmassalski.bankapp.domain.user.User;
import com.tmassalski.bankapp.domain.user.UserRetrievalClient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Getter
class AccountCreator {

    private final AccountNumberGenerator accountNumberGenerator;
    private final UserRetrievalClient userRetrievalClient;

    @Transactional
    public void createAccountAndAssignToUser(long userId) {
        Account newAccount = createAccount();
        User user = userRetrievalClient.getById(userId);
        user.addAccount(newAccount);
    }

    Account createAccount(){
        String accountNumber = accountNumberGenerator.generate();
        return Account.generate(accountNumber);
    }
}
