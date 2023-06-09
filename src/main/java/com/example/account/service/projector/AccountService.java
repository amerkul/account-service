package com.example.account.service.projector;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.aggregate.filter.AccountFilter;
import reactor.core.publisher.Flux;

public interface AccountService {
    Flux<AccountAggregate> retrieveAll();
    Flux<AccountAggregate> retrieveAllByFilter(AccountFilter filter);

}
