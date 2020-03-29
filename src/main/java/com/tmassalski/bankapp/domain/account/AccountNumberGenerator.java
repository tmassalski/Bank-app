package com.tmassalski.bankapp.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class AccountNumberGenerator {

    String generate() {
        String randomUUID =  UUID.randomUUID().toString().replaceAll("[-|a-z]", "0");
        return randomUUID.substring(0,26);
    }
}
