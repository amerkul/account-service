package com.example.account.service.command;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.command.CreateAccountCommand;
import com.example.account.domain.command.UpdateAccountCommand;
import reactor.core.publisher.Mono;

public interface CommandService {

    Mono<AccountAggregate> createAccount(CreateAccountCommand command);
    Mono<AccountAggregate> update(UpdateAccountCommand updateAccountCommand);

}
