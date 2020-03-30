package com.tmassalski.bankapp.domain.transfer;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class TransferCommand {

    private final long ownerId;
    private final long ownerAccountId;
    private final String senderAccountNumber;
    private final BigDecimal amount;
    private final String title;
}
