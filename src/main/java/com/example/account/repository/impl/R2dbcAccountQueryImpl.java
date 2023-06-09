package com.example.account.repository.impl;

import com.example.account.domain.aggregate.filter.AccountFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class R2dbcAccountQueryImpl implements R2dbcAccountQuery {

    @Override
    public Query createCriteriaQueryWithFilter(AccountFilter filter) {
        log.debug("Account criteria filter " + filter);
        Criteria criteria = new R2dbcCriteriaBuilder(Criteria.empty())
                .containsColumn(filter.getName(), "name")
                .containsColumn(filter.getStatus(), "status")
                .getCriteria();
        return Query.query(criteria);
    }

}
