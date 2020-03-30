package com.tmassalski.bankapp.api.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Builder
@Getter
class TransferRequest {

    @Min(1)
    private final long ownerId;

    @Min(1)
    private final long ownerAccountId;

    @NotBlank
    private final String clientAccountNumber;

    @DecimalMin("0.01")
    @JsonProperty("totalPrice")
    private final BigDecimal amount;

    @NotBlank
    private final String title;
}
