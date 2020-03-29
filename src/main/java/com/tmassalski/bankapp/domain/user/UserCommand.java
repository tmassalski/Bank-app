package com.tmassalski.bankapp.domain.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCommand {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
}
