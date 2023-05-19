package com.example.account.elastic.repository.impl;

import com.example.account.elastic.data.criteria.AccountCriteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;

public interface AccountCriteriaQuery {

    CriteriaQuery createAccountCriteriaQuery(AccountCriteria criteria);

}
