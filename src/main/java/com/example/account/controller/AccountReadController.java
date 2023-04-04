package com.example.account.controller;

import com.example.account.aggregate.AccountAggregate;
import com.example.account.service.projector.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountReadController {

    private final AccountService service;

    @GetMapping("/all")
    public Flux<AccountAggregate> list() {
        return service.retrieveAllEvents();
    }

}
