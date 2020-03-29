package com.tmassalski.bankapp.domain.account;

public interface RetrieveAccountClient {

    Account findById(long accountId);
    Account findByAccountNumber(String accountNumber);
}
