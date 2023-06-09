package com.example.account.repository.impl;

import com.example.account.domain.data.criteria.AccountCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ElasticAccountCriteriaQueryImpl implements ElasticAccountCriteriaQuery {

    @Override
    public CriteriaQuery createAccountCriteriaQuery(AccountCriteria accountCriteria) {
        log.debug("Account criteria entity " + accountCriteria);
        Criteria criteria = new ElasticCriteriaBuilder(new Criteria())
                .containsIfNotNull(accountCriteria.getName(), "name")
                .greaterThanEqualIfNotNull(accountCriteria.getBalanceGte(), "balance")
                .lessThanEqualIfNotNull(accountCriteria.getBalanceLte(), "balance")
                .isIfNotNull(accountCriteria.getStatus(), "status")
                .isIfNotNull(accountCriteria.getAuctionId(), "auction_id")
                .greaterThanEqualIfNotNull(accountCriteria.getReservedGte(), "reserved")
                .lessThanEqualIfNotNull(accountCriteria.getReservedLte(), "reserved")
                .criteria();
        return new CriteriaQuery(criteria);
    }

}
