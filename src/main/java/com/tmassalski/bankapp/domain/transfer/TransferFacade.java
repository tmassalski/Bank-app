package com.tmassalski.bankapp.domain.transfer;

import com.tmassalski.bankapp.domain.account.Account;
import com.tmassalski.bankapp.domain.account.RetrieveAccountClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferFacade {

    private final RetrieveAccountClient retrieveAccountClient;
    private final CreateTransferClient createTransferClient;
    private final TransferCreator transferCreator;

    @Transactional
    public void processTransfer(TransferCommand command) {
        Account recipientAccount = retrieveAccountClient.findById(command.getOwnerId());
        Optional<Account> optionalSenderAccount = retrieveAccountClient.findByAccountNumber(command.getSenderAccountNumber());
        if (optionalSenderAccount.isPresent()) {
            optionalSenderAccount.get().reduceBalance(command.getAmount());
        }
        recipientAccount.increaseBalance(command.getAmount());
        Transfer transfer =  transferCreator.generate(command, recipientAccount.getAccountNumber());
        createTransferClient.save(transfer);
    }
}
