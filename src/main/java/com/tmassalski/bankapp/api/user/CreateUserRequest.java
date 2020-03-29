package com.tmassalski.bankapp.api.user;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
class CreateUserRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
