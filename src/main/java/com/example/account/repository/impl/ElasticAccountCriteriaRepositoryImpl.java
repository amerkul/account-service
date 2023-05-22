package com.example.account.repository.impl;

import com.example.account.domain.data.Account;
import com.example.account.domain.data.criteria.AccountCriteria;
import com.example.account.repository.ElasticAccountCriteriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@AllArgsConstructor
public class ElasticAccountCriteriaRepositoryImpl implements ElasticAccountCriteriaRepository {

    private static final String ACCOUNT_INDEX = "account";

    private final ReactiveElasticsearchOperations operations;
    private final AccountCriteriaQuery accountCriteriaQuery;

    @Override
    public Flux<Account> findByCriteria(AccountCriteria accountCriteria, Pageable pageable) {
        Query query = accountCriteriaQuery.createAccountCriteriaQuery(accountCriteria)
                .setPageable(pageable);
        Flux<SearchHit<Account>> flux = operations.search(query, Account.class, IndexCoordinates.of(ACCOUNT_INDEX));
        return flux.map(SearchHit::getContent);
    }

}
