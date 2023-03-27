package com.example.account.projector;

import com.example.account.event.AccountCreatedEvent;
import com.example.account.event.Event;
import com.example.account.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class AccountProjector {

    private final EventRepository repository;

    public Flux<AccountCreatedEvent> retrieveAllEvents() {
        return repository.findAll();
    }

}
