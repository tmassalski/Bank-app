package com.tmassalski.bankapp.infrastructure.transfer;

import com.tmassalski.bankapp.domain.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
