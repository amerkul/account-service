package com.example.account.service.projector;

import com.example.account.aggregate.AccountAggregate;
import reactor.core.publisher.Flux;

public interface AccountService {
    Flux<AccountAggregate> retrieveAllEvents();

}
