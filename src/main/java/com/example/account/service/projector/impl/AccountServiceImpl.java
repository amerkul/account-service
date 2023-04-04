package com.example.account.service.projector.impl;

import com.example.account.aggregate.AccountAggregate;
import com.example.account.repository.AccountRepository;
import com.example.account.service.projector.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public Flux<AccountAggregate> retrieveAllEvents() {
        return repository.findAll();
    }

}
