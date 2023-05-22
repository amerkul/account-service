package com.example.account.service.command.impl;

import com.example.account.aggregate.AccountAggregate;
import com.example.account.aggregate.BidStatus;
import com.example.account.command.CreateAccountCommand;
import com.example.account.command.UpdateAccountCommand;
import com.example.account.event.AccountCreatedEvent;
import com.example.account.event.AccountUpdatedEvent;
import com.example.account.event.EventHandler;
import com.example.account.kafka.producer.ProducerService;
import com.example.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommandServiceImplTest {

    @InjectMocks
    CommandServiceImpl service;
    @Mock
    ProducerService producerService;
    @Mock
    AccountRepository accountRepository;
    @Mock
    EventHandler eventHandler;

    @Test
    void createAccount() {
        AccountAggregate accountAggregate = new AccountAggregate();
        accountAggregate.setAccountId(1L);
        accountAggregate.setReserved(22);
        accountAggregate.setBalance(33);
        accountAggregate.setAuctionId("sdcsd");
        accountAggregate.setName("vcxc");
        accountAggregate.setStatus(BidStatus.PENDING);
        doNothing().when(eventHandler).handle(Mockito.any(AccountCreatedEvent.class));
        doNothing().when(producerService).send(Mockito.any(AccountCreatedEvent.class));
        when(accountRepository.save(Mockito.any(AccountAggregate.class)))
                .thenReturn(Mono.just(accountAggregate));
        Mono<AccountAggregate> account = service.createAccount(getTestCreateCommand());
        StepVerifier.create(account)
                .expectNext(accountAggregate)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void update() {
        AccountAggregate accountAggregate = new AccountAggregate();
        accountAggregate.setAccountId(1L);
        accountAggregate.setReserved(22);
        accountAggregate.setBalance(33);
        accountAggregate.setAuctionId("sdcsd");
        accountAggregate.setName("vcxc");
        accountAggregate.setStatus(BidStatus.REJECTED);
        doNothing().when(eventHandler).handle(Mockito.any(AccountUpdatedEvent.class));
        when(accountRepository.save(Mockito.any(AccountAggregate.class)))
                .thenReturn(Mono.just(accountAggregate));
        Mono<AccountAggregate> account = service.update(getTestUpdateCommand());
        StepVerifier.create(account)
                .expectNext(accountAggregate)
                .expectNextCount(0)
                .verifyComplete();
    }

    private CreateAccountCommand getTestCreateCommand() {
        CreateAccountCommand command = new CreateAccountCommand();
        command.setName("nkn");
        command.setBalance(666);
        command.setAuctionId("hnnhknk");
        command.setReserved(75);
        return command;
    }

    private UpdateAccountCommand getTestUpdateCommand() {
        UpdateAccountCommand command = new UpdateAccountCommand();
        command.setName("nkn");
        command.setBalance(666);
        command.setAuctionId("hnnhknk");
        command.setReserved(75);
        command.setStatus(BidStatus.ACCEPTED);
        return command;
    }

}
