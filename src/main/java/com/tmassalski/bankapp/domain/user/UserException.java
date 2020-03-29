package com.tmassalski.bankapp.domain.user;

public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }

    public static UserException userIdNotFound(long id) {
        return new UserException(String.format
                ("User not found [id=%s]", id));
    }
}
