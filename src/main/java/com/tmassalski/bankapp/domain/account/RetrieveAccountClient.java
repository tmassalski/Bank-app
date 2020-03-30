package com.tmassalski.bankapp.domain.account;

import java.util.Optional;

public interface RetrieveAccountClient {

    Account findById(long accountId);
    Optional<Account> findByAccountNumber(String accountNumber);
}
