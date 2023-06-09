package com.example.account.repository.impl;

import com.example.account.domain.aggregate.filter.AccountFilter;
import org.springframework.data.relational.core.query.Query;

public interface R2dbcAccountQuery {

    Query createCriteriaQueryWithFilter(AccountFilter filter);

}
