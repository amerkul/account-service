package com.example.account.controller;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.service.projector.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountReadController {

    private final AccountService service;

    @GetMapping("/all")
    public Flux<AccountAggregate> list() {
        log.info("Get list accounts...");
        return service.retrieveAll();
    }

}
