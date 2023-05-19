package com.example.account.elastic.repository.impl;

import com.example.account.elastic.data.Account;
import com.example.account.elastic.data.criteria.AccountCriteria;
import com.example.account.elastic.repository.ElasticAccountRepository;
import com.example.account.property.TestProperty;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@Testcontainers
@DataElasticsearchTest(excludeAutoConfiguration = {PostgresqlConnectionConfiguration.class, LiquibaseAutoConfiguration.class})
class ElasticAccountCriteriaRepositoryImplTest {

    @Container
    static ElasticsearchContainer elastic = new ElascticsearchContainerConfig();

    @Autowired
    ElasticAccountRepository elasticAccountRepository;

    @MockBean
    AccountCriteriaQuery accountCriteriaQuery;

    @DynamicPropertySource
    static void init(DynamicPropertyRegistry registry) {
        TestProperty.setProperties(registry);
    }

    @BeforeAll
    static void init(){
        elastic.start();
    }

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


    @AfterAll
    static void destroy() {
        elastic.stop();
    }

}