package com.example.account.repository.impl;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.aggregate.filter.AccountFilter;
import com.example.account.repository.R2dbcAccountCriteriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@AllArgsConstructor
public class R2dbcAccountCriteriaRepositoryImpl implements R2dbcAccountCriteriaRepository {

    private final R2dbcEntityOperations operations;
    private final R2dbcAccountQuery accountQuery;

    @Override
    public Flux<AccountAggregate> findByFilter(AccountFilter filter) {
        Query query = accountQuery.createCriteriaQueryWithFilter(filter);
        return this.operations.select(AccountAggregate.class)
                .matching(query)
                .all();
    }

}
