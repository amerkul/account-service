package com.example.account.service.command;

import com.example.account.aggregate.AccountAggregate;
import com.example.account.command.CreateAccountCommand;
import com.example.account.command.UpdateAccountCommand;
import reactor.core.publisher.Mono;

public interface CommandService {

    Mono<AccountAggregate> createAccount(CreateAccountCommand command);
    Mono<AccountAggregate> update(UpdateAccountCommand updateAccountCommand);

}
