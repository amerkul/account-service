package com.example.account.repository.impl;

import com.example.account.domain.data.Account;
import com.example.account.domain.data.criteria.AccountCriteria;
import com.example.account.repository.ElasticAccountRepository;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@DataElasticsearchTest(excludeAutoConfiguration = {PostgresqlConnectionConfiguration.class, LiquibaseAutoConfiguration.class})
class ElasticAccountCriteriaRepositoryImplTest extends BaseElasticDockerConfiguration {

    @Autowired
    ElasticAccountRepository elasticAccountRepository;

    @MockBean
    AccountCriteriaQuery accountCriteriaQuery;

    @Test
    void findByCriteria() {
        AccountCriteria criteria = new AccountCriteria();
        criteria.setAuctionId("a");
        criteria.setName("a");
        criteria.setStatus("a");
        criteria.setBalanceGte(1);
        criteria.setBalanceLte(10);
        criteria.setReservedGte(1);
        criteria.setReservedLte(10);
        CriteriaQuery criteriaQuery = new CriteriaQuery(new Criteria());
        when(accountCriteriaQuery.createAccountCriteriaQuery(criteria)).thenReturn(criteriaQuery);
        Flux<Account> flux = elasticAccountRepository.findByCriteria(criteria, PageRequest.of(0,100));
        StepVerifier.create(flux)
                .expectNextCount(0)
                .verifyComplete();
    }

}
