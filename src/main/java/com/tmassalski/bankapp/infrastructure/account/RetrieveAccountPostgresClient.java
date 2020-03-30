package com.tmassalski.bankapp.infrastructure.account;

import com.tmassalski.bankapp.domain.account.Account;
import com.tmassalski.bankapp.domain.account.AccountException;
import com.tmassalski.bankapp.domain.account.RetrieveAccountClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrieveAccountPostgresClient implements RetrieveAccountClient {

    private final AccountRepository accountRepository;

    @Override
    public Account findById(long accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        return optionalAccount.orElseThrow(() -> AccountException.accountNotFound(accountId));
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
}
