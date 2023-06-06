package com.example.account.controller;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.command.CreateAccountCommand;
import com.example.account.service.command.CommandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountWriteController {

    private final CommandService commandService;

    @PostMapping( "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AccountAggregate> create(@RequestBody CreateAccountCommand createAccountCommand) {
        log.info("Start creating account...");
        return commandService.createAccount(createAccountCommand);
    }

}
