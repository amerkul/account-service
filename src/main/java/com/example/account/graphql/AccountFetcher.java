package com.example.account.graphql;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.service.projector.AccountService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@DgsComponent
@AllArgsConstructor
public class AccountFetcher {

    private final AccountService service;

    @DgsData(parentType = "Query", field = "accounts")
    public Flux<AccountAggregate> fetchAll() {
        return service.retrieveAll();
    }

}
