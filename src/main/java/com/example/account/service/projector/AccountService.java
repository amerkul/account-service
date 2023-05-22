package com.example.account.service.projector;

import com.example.account.domain.aggregate.AccountAggregate;
import reactor.core.publisher.Flux;

public interface AccountService {
    Flux<AccountAggregate> retrieveAllEvents();

}
