package com.tmassalski.bankapp.domain.transfer;

import org.springframework.stereotype.Service;

@Service
class TransferCreator {

    Transfer generate(TransferCommand command, String recipientAccountNumber) {
        return Transfer.builder()
                .senderAccountNumber(command.getSenderAccountNumber())
                .recipientAccountNumber(recipientAccountNumber)
                .amount(command.getAmount())
                .title(command.getTitle())
                .build();
    }
}
