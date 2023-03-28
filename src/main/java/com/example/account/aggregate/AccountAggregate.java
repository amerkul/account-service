package com.example.account.aggregate;

import com.example.account.command.CreateAccountCommand;
import com.example.account.event.AccountCreatedEvent;
import com.example.account.event.BidStatus;
import com.example.account.event.Event;
import com.example.account.repository.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class AccountAggregate {

    private final EventRepository repository;

    @SneakyThrows
    public Mono<Event> save(CreateAccountCommand newAccount) {
        log.info("Create: {}", newAccount);
        AccountCreatedEvent event = new AccountCreatedEvent();
        event.setBalance(newAccount.getBalance());
        event.setName(newAccount.getName());
        event.setReserved(newAccount.getReserved());
        event.setAuctionId(newAccount.getAuctionId());
        event.setStatus(BidStatus.PENDING);
        ObjectMapper mapper = new ObjectMapper();
        return repository.save(new Event(event.getClass().getName(), mapper.writeValueAsString(event)));
    }

}
