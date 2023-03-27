package com.example.account.controller;

import com.example.account.event.AccountCreatedEvent;
import com.example.account.projector.AccountProjector;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountReadController {

    private final AccountProjector service;

    @GetMapping("/all")
    public Flux<AccountCreatedEvent> list() {
        return service.retrieveAllEvents();
    }

}
