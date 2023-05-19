package com.example.account.controller;

import com.example.account.aggregate.AccountAggregate;
import com.example.account.command.CreateAccountCommand;
import com.example.account.service.command.CommandService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountWriteControllerTest {

    @Mock
    CommandService commandService;
    @InjectMocks
    AccountWriteController controller;

    @Test
    void create() {
        CreateAccountCommand createAccountCommand = new CreateAccountCommand();
        AccountAggregate account = new AccountAggregate();
        Mono<AccountAggregate> mono = Mono.just(account);
        when(commandService.createAccount(createAccountCommand)).thenReturn(mono);
        Mono<AccountAggregate> result = controller.create(createAccountCommand);
        StepVerifier.create(result)
                .expectNext(account)
                .verifyComplete();
    }

}
