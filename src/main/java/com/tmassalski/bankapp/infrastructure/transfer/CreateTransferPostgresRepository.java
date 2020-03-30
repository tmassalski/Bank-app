package com.tmassalski.bankapp.infrastructure.transfer;

import com.tmassalski.bankapp.domain.transfer.CreateTransferClient;
import com.tmassalski.bankapp.domain.transfer.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTransferPostgresRepository implements CreateTransferClient {

    private final TransferRepository transferRepository;

    @Override
    public void save(Transfer transfer) {
        transferRepository.save(transfer);
    }
}
