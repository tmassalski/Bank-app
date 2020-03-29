package com.tmassalski.bankapp.domain.account;

import com.tmassalski.bankapp.domain.Auditable;
import com.tmassalski.bankapp.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Account extends Auditable {

    private static final BigDecimal initialFee = BigDecimal.ZERO;
    private static final BigDecimal initialBalance = BigDecimal.ZERO;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "account_sequence")
    private long id;

    @Column(unique = true)
    private String accountNumber;

    private BigDecimal balance;
    private BigDecimal fee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    static Account generate(String accountNumber) {
        return Account.builder()
                .accountNumber(accountNumber)
                .balance(initialBalance)
                .fee(initialFee)
                .build();
    }

    void increaseBalance(BigDecimal amountToAdd) {
        balance = balance.add(amountToAdd);
    }

    void reduceBalance(BigDecimal amountToSubtract) {
        if (balance.compareTo(amountToSubtract)<0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough funds to complete this operation");
        } else {
            balance = balance.subtract(amountToSubtract);
        }
    }
}
