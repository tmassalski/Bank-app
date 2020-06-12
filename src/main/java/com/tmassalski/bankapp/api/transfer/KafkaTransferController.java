package com.tmassalski.bankapp.api.transfer;

import com.tmassalski.bankapp.domain.transfer.TransferCommand;
import com.tmassalski.bankapp.domain.transfer.TransferFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CountDownLatch;

@RequiredArgsConstructor
@Controller
public class KafkaTransferController {

    private final CountDownLatch countDownLatch = new CountDownLatch(1);
    private final TransferFacade transferFacade;

    @KafkaListener(topics = "${message.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void processTransfer(TransferRequest transferRequest) {
        System.out.println("received " + transferRequest);
        transferFacade.processTransfer(transferCommandBuilder(transferRequest));
        countDownLatch.countDown();
    }

    TransferCommand transferCommandBuilder(TransferRequest transferRequest) {
        return TransferCommand.builder()
                .ownerId(transferRequest.getOwnerId())
                .ownerAccountId(transferRequest.getOwnerAccountId())
                .senderAccountNumber(transferRequest.getClientAccountNumber())
                .amount(transferRequest.getAmount())
                .title(transferRequest.getTitle())
                .build();
    }
}
