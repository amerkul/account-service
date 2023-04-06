package com.example.account.service.command.impl;

import com.example.account.aggregate.AccountAggregate;
import com.example.account.command.CreateAccountCommand;
import com.example.account.aggregate.BidStatus;
import com.example.account.command.UpdateAccountCommand;
import com.example.account.event.AccountCreatedEvent;
import com.example.account.event.AccountUpdatedEvent;
import com.example.account.event.EventHandler;
import com.example.account.repository.AccountRepository;
import com.example.account.service.command.CommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommandServiceImpl implements CommandService {

    private final AccountRepository accountRepository;
    private final EventHandler eventHandler;

    @Override
    public void createAccount(CreateAccountCommand command) {
        AccountAggregate accountAggregate = AccountAggregate.builder()
                                                            .status(BidStatus.PENDING)
                                                            .name(command.getName())
                                                            .balance(command.getBalance())
                                                            .reserved(command.getReserved())
                                                            .auctionId(command.getAuctionId())
                                                            .build();
        accountRepository.save(accountAggregate)
                         .doOnNext(accountCreated -> {
                             AccountCreatedEvent event = new AccountCreatedEvent();
                             event.apply(accountAggregate);
                             eventHandler.handle(event);
                         }).subscribe();
    }

    @Override
    public void update(UpdateAccountCommand command) {
        AccountAggregate accountAggregate = AccountAggregate.builder()
                                                            .status(command.getStatus())
                                                            .name(command.getName())
                                                            .balance(command.getBalance())
                                                            .reserved(command.getReserved())
                                                            .auctionId(command.getAuctionId())
                                                            .build();
        accountRepository.save(accountAggregate)
                         .doOnNext(accountUpdated -> {
                             AccountUpdatedEvent event = new AccountUpdatedEvent();
                             event.apply(accountAggregate);
                             eventHandler.handle(event);
                         }).subscribe();
    }

}
