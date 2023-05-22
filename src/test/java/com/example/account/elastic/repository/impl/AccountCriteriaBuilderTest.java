package com.example.account.elastic.repository.impl;

import org.junit.jupiter.api.Test;
import org.springframework.data.elasticsearch.core.query.Criteria;

import static org.junit.jupiter.api.Assertions.*;

class AccountCriteriaBuilderTest {

    @Test
    void getCriteria() {
        Criteria criteria = new CriteriaBuilder().getCriteria();
        assertNotNull(criteria);
    }

    @Test
    void containsIfNotNull() {
        Criteria criteria = new CriteriaBuilder()
                .containsIfNotNull("sdjcn", "cdkmxkds")
                .getCriteria();
        assertEquals(1, criteria.getCriteriaChain().size());
    }

    @Test
    void isIfNotNull() {
        Criteria criteria = new CriteriaBuilder()
                .isIfNotNull("sdjcn", "cdkmxkds")
                .getCriteria();
        assertEquals(1, criteria.getCriteriaChain().size());
    }

    @Test
    void greaterThanEqualIfNotNull() {
        Criteria criteria = new CriteriaBuilder()
                .greaterThanEqualIfNotNull(12, "cdkmxkds")
                .getCriteria();
        assertEquals(1, criteria.getCriteriaChain().size());
    }

    @Test
    void lessThanEqualIfNotNull() {
        Criteria criteria = new CriteriaBuilder()
                .greaterThanEqualIfNotNull(12, "cdkmxkds")
                .getCriteria();
        assertEquals(1, criteria.getCriteriaChain().size());
    }

}