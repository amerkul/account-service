package com.example.account.repository;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.aggregate.filter.AccountFilter;
import reactor.core.publisher.Flux;

public interface R2dbcAccountCriteriaRepository {

    Flux<AccountAggregate> findByFilter(AccountFilter filter);

}
