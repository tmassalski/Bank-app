package com.tmassalski.bankapp.domain.account;

public class AccountException extends RuntimeException {

    public AccountException(String message) {
        super(message);
    }

    public static AccountException accountNotFound(long id){
        return new AccountException(String.format
                ("Account not found [id=%s]", id));
    }

    public static AccountException accountNotFound(String accountNumber){
        return new AccountException(String.format
                ("Account not found [id=%s]", accountNumber));
    }
}
