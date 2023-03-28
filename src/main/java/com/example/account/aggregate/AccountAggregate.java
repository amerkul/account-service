package com.example.account.aggregate;

import com.example.account.command.CreateAccountCommand;
import com.example.account.command.UpdateAccountCommand;
import com.example.account.event.AccountCreatedEvent;
import com.example.account.event.AccountUpdatedEvent;
import com.example.account.event.BidStatus;
import com.example.account.event.Event;
import com.example.account.kafka.producer.ReactiveProducerService;
import com.example.account.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class AccountAggregate {

    private final EventRepository repository;
    private final ReactiveProducerService producerService;

    public Mono<Event> save(CreateAccountCommand newAccount) {
        log.info("Create: {}", newAccount);
        AccountCreatedEvent event = new AccountCreatedEvent();
        event.setBalance(newAccount.getBalance());
        event.setName(newAccount.getName());
        event.setReserved(newAccount.getReserved());
        event.setAuctionId(newAccount.getAuctionId());
        event.setType(event.getClass().getName());
        event.setStatus(BidStatus.PENDING);
        producerService.send(event);
        log.info("Event: " + event);
        return repository.save(event);
    }

    public Mono<Event> update(UpdateAccountCommand command) {
        log.info("Update: {}", command);
        AccountUpdatedEvent event = new AccountUpdatedEvent();
        event.setBalance(command.getBalance());
        event.setName(command.getName());
        event.setReserved(command.getReserved());
        event.setAuctionId(command.getAuctionId());
        event.setType(event.getClass().getName());
        event.setStatus(command.getStatus());
        log.info("Event: " + event);
        return repository.save(event);
    }

}
