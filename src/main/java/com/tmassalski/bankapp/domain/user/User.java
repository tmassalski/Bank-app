package com.tmassalski.bankapp.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tmassalski.bankapp.domain.Auditable;
import com.tmassalski.bankapp.domain.account.Account;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends Auditable {

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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();

    @JsonIgnore
    @Setter(value = AccessLevel.PRIVATE)
    private String password;

    public void addAccount(Account account) {
        if (accounts == null) {
            accounts = new HashSet<>();
        }
        accounts.add(account);
        account.setUser(this);
    }

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
