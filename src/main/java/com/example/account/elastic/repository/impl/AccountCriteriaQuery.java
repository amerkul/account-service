package com.example.account.elastic.repository.impl;

import com.example.account.elastic.data.criteria.AccountCriteria;
import org.springframework.data.elasticsearch.core.query.Query;

public interface AccountCriteriaQuery {

    Query createAccountCriteriaQuery(AccountCriteria criteria);

}
