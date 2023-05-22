package com.example.account.elastic.repository.impl;

import com.example.account.elastic.data.criteria.AccountCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountCriteriaQueryImpl implements AccountCriteriaQuery {

    @Override
    public CriteriaQuery createAccountCriteriaQuery(AccountCriteria accountCriteria) {
        log.debug("Account criteria entity " + accountCriteria);
        Criteria criteria = new CriteriaBuilder()
                .containsIfNotNull(accountCriteria.getName(), "name")
                .greaterThanEqualIfNotNull(accountCriteria.getBalanceGte(), "balance")
                .lessThanEqualIfNotNull(accountCriteria.getBalanceLte(), "balance")
                .isIfNotNull(accountCriteria.getStatus(), "status")
                .isIfNotNull(accountCriteria.getAuctionId(), "auction_id")
                .greaterThanEqualIfNotNull(accountCriteria.getReservedGte(), "reserved")
                .lessThanEqualIfNotNull(accountCriteria.getReservedLte(), "reserved")
                .getCriteria();
        return new CriteriaQuery(criteria);
    }

}
