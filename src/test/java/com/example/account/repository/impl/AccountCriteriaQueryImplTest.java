package com.example.account.repository.impl;

import com.example.account.domain.data.criteria.AccountCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountCriteriaQueryImplTest {
    @Test
    void createAccountCriteriaQuery() {
        ElasticAccountCriteriaQuery accountCriteriaQuery = new ElasticAccountCriteriaQueryImpl();
        AccountCriteria accountCriteria = new AccountCriteria();
        accountCriteria.setName("hhjj");
        CriteriaQuery query = accountCriteriaQuery.createAccountCriteriaQuery(accountCriteria);
        assertEquals(1, query.getCriteria().getCriteriaChain().size());
    }

}
