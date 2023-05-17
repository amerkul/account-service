package com.example.account.elastic.repository;

import com.example.account.elastic.data.Account;
import com.example.account.elastic.data.criteria.AccountCriteria;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ElasticAccountCriteriaRepository {

    Flux<Account> findByCriteria(AccountCriteria accountCriteria, Pageable pageable);

}
