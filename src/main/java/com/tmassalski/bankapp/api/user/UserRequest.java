package com.tmassalski.bankapp.api.user;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Value
class UserRequest {

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    @NotBlank
    private final String login;

    @NotBlank
    private final String password;

    @Email
    private final String email;
}
