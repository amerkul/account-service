package com.example.account.elastic.service;

import com.example.account.elastic.data.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface ElasticAccountService {

    Mono<Account> retrieveById(long id);
    Flux<Account> retrieveByName(String name);
    Flux<Account> retrieveByBalanceBetween(int from, int to);
    Flux<Account> retrieveByParams(Map<String, String> params);

}
