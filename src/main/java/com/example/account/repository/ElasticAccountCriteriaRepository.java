package com.example.account.repository;

import com.example.account.domain.data.Account;
import com.example.account.domain.data.criteria.AccountCriteria;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ElasticAccountCriteriaRepository {

    Flux<Account> findByCriteria(AccountCriteria accountCriteria, Pageable pageable);

}
