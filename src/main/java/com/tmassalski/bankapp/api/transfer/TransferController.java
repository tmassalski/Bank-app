package com.tmassalski.bankapp.api.transfer;

import com.tmassalski.bankapp.domain.transfer.TransferCommand;
import com.tmassalski.bankapp.domain.transfer.TransferFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfers")
class TransferController {

    private final TransferFacade transferFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    void processTransfer(@Valid @RequestBody TransferRequest request) {
        transferFacade.processTransfer(transferCommandBuilder(request));
    }

    @PostMapping("/pending")
    void processPendingTransfers(@Valid @RequestBody Set<TransferRequest> requestSet) {
        requestSet.forEach(transferRequest -> transferFacade.processTransfer(transferCommandBuilder(transferRequest)));
    }

    TransferCommand transferCommandBuilder(TransferRequest request) {
        return TransferCommand.builder()
                .ownerId(request.getOwnerId())
                .ownerAccountId(request.getOwnerAccountId())
                .senderAccountNumber(request.getClientAccountNumber())
                .amount(request.getAmount())
                .title(request.getTitle())
                .build();
    }
}
