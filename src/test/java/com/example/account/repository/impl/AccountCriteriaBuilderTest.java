package com.example.account.repository.impl;

import org.junit.jupiter.api.Test;
import org.springframework.data.elasticsearch.core.query.Criteria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountCriteriaBuilderTest {

    @Test
    void getCriteria() {
        Criteria criteria = new ElasticCriteriaBuilder(new Criteria()).criteria();
        assertNotNull(criteria);
    }

    @Test
    void containsIfNotNull() {
        Criteria criteria = new ElasticCriteriaBuilder(new Criteria())
                .containsIfNotNull("sdjcn", "cdkmxkds")
                .criteria();
        assertEquals(1, criteria.getCriteriaChain().size());
    }

    @Test
    void isIfNotNull() {
        Criteria criteria = new ElasticCriteriaBuilder(new Criteria())
                .isIfNotNull("sdjcn", "cdkmxkds")
                .criteria();
        assertEquals(1, criteria.getCriteriaChain().size());
    }

    @Test
    void greaterThanEqualIfNotNull() {
        Criteria criteria = new ElasticCriteriaBuilder(new Criteria())
                .greaterThanEqualIfNotNull(12, "cdkmxkds")
                .criteria();
        assertEquals(1, criteria.getCriteriaChain().size());
    }

    @Test
    void lessThanEqualIfNotNull() {
        Criteria criteria = new ElasticCriteriaBuilder(new Criteria())
                .greaterThanEqualIfNotNull(12, "cdkmxkds")
                .criteria();
        assertEquals(1, criteria.getCriteriaChain().size());
    }

}