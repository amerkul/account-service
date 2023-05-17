package com.example.account.elastic.repository;

import com.example.account.elastic.data.Account;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux;

public interface ElasticAccountRepository extends ReactiveElasticsearchRepository<Account, Long>, ElasticAccountCriteriaRepository {

    Flux<Account> findAccountByName(String name);
    Flux<Account> findAccountByBalanceBetween(int from, int to);

}
