package com.example.account.elastic.repository.impl;

import com.example.account.elastic.data.criteria.AccountCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountCriteriaQueryImplTest {
    @Test
    void createAccountCriteriaQuery() {
        AccountCriteriaQuery accountCriteriaQuery = new AccountCriteriaQueryImpl();
        AccountCriteria accountCriteria = new AccountCriteria();
        accountCriteria.setName("hhjj");
        CriteriaQuery query = accountCriteriaQuery.createAccountCriteriaQuery(accountCriteria);
        assertEquals(1, query.getCriteria().getCriteriaChain().size());
    }

}