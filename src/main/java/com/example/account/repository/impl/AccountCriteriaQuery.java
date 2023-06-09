package com.example.account.repository.impl;

import com.example.account.domain.data.criteria.AccountCriteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;

public interface AccountCriteriaQuery {

    CriteriaQuery createAccountCriteriaQuery(AccountCriteria criteria);

}
