package com.example.account.service;

import com.example.account.domain.data.Account;
import com.example.account.domain.data.criteria.AccountCriteria;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ElasticAccountService {

    Mono<Account> retrieveById(long id);
    Flux<Account> retrieveByName(String name);
    Flux<Account> retrieveByBalanceBetween(int from, int to);
    Flux<Account> retrieveByParams(AccountCriteria criteria, Pageable pageable);

}
