package com.tmassalski.bankapp.domain.transfer;

import com.tmassalski.bankapp.domain.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Transfer extends Auditable {

    @Id
    @GeneratedValue(generator = "transfer_sequence")
    private long id;

    private BigDecimal amount;
    private String recipientAccountNumber;
    private String senderAccountNumber;
    private String title;
}
