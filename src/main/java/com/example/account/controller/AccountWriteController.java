package com.example.account.controller;

import com.example.account.aggregate.AccountAggregate;
import com.example.account.command.CreateAccountCommand;
import com.example.account.event.AccountCreatedEvent;
import com.example.account.event.Event;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountWriteController {

    private final AccountAggregate service;

    @PostMapping( "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Event> create(@RequestBody CreateAccountCommand createAccountCommand) {
        return service.save(createAccountCommand);
    }

}
