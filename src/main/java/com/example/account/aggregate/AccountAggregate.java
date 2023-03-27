package com.example.account.aggregate;

import com.example.account.command.CreateAccountCommand;
import com.example.account.event.AccountCreatedEvent;
import com.example.account.event.BidStatus;
import com.example.account.event.Event;
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

    public Mono<AccountCreatedEvent> save(CreateAccountCommand newAccount) {
        log.info("Create: {}", newAccount);

        AccountCreatedEvent event = new AccountCreatedEvent();
        event.setBalance(newAccount.getBalance());
        event.setName(newAccount.getName());
        event.setReserved(newAccount.getReserved());
        event.setAuctionId(newAccount.getAuctionId());
        event.setType(event.getClass().getName());
        event.setStatus(BidStatus.PENDING);

        log.info("Event: " + event);
        return repository.save(event);
    }

}
