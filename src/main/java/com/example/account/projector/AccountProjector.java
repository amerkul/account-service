package com.example.account.projector;

import com.example.account.event.AccountCreatedEvent;
import com.example.account.repository.AccountCreatedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class AccountProjector {

    private final AccountCreatedRepository repository;

    public Flux<AccountCreatedEvent> retrieveAllEvents() {
        return repository.findAll();
    }

}
