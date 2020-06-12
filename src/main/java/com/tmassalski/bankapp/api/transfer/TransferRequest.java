package com.tmassalski.bankapp.api.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Builder
@Getter
@JsonDeserialize(builder = TransferRequest.TransferRequestBuilder.class)
public class TransferRequest {

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

    @JsonPOJOBuilder(withPrefix = "")
    public static class TransferRequestBuilder {
    }
}