package com.tmassalski.bankapp.domain.transfer;

import org.springframework.stereotype.Service;

@Service
class TransferCreator {

    Transfer generate(TransferCommand command, String senderAccountNumber) {
        return Transfer.builder()
                .senderAccountNumber(senderAccountNumber)
                .recipientAccountNumber(command.getSenderAccountNumber())
                .amount(command.getAmount())
                .title(command.getTitle())
                .build();
    }
}
