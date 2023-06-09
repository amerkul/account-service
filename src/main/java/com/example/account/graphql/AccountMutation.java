package com.example.account.graphql;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.command.CreateAccountCommand;
import com.example.account.graphql.dto.AccountInput;
import com.example.account.service.command.CommandService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Mono;

@DgsComponent
@AllArgsConstructor
public class AccountMutation {

    private final CommandService service;
    private final ModelMapper mapper;

    @DgsData(parentType = "Mutation", field = "newAccount")
    public Mono<AccountAggregate> newAccount(AccountInput input) {
        CreateAccountCommand command = mapper.map(input, CreateAccountCommand.class);
        return service.createAccount(command);
    }

}
