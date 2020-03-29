package com.tmassalski.bankapp.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
    @JsonIgnore
    @Setter(value = AccessLevel.PRIVATE)
    private Long id;

    @Setter
    private String firstName;
    @Setter
    private String lastName;

    @Column(unique = true)
    @Setter
    private String email;

    @Column(unique = true)
    @Setter
    private String login;

    @JsonIgnore
    @Setter(value = AccessLevel.PRIVATE)
    private String password;

    static User generate(UserCommand userCommand) {
        return User.builder()
                .firstName(userCommand.getFirstName())
                .lastName(userCommand.getLastName())
                .email(userCommand.getEmail())
                .login(userCommand.getLogin())
                .password(userCommand.getPassword())
                .build();
    }
}
