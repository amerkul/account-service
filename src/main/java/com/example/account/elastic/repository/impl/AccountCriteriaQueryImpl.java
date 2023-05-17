package com.example.account.elastic.repository.impl;

import com.example.account.elastic.data.criteria.AccountCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountCriteriaQueryImpl implements AccountCriteriaQuery {

    @Override
    public Query createAccountCriteriaQuery(AccountCriteria accountCriteria) {
        log.debug("Account criteria entity " + accountCriteria);
        Criteria criteria = new Criteria();
        if (accountCriteria.getName() != null) {
            criteria.and(Criteria.where("name")
                    .contains(accountCriteria.getName()));
        }
        if (accountCriteria.getBalanceGte() != null) {
            criteria.and(Criteria.where("balance")
                    .greaterThanEqual(accountCriteria.getBalanceGte()));
        }
        if (accountCriteria.getBalanceLte() != null) {
            criteria.and(Criteria.where("balance")
                    .lessThanEqual(accountCriteria.getBalanceLte()));
        }
        if (accountCriteria.getStatus() != null) {
            criteria.and(Criteria.where("status")
                    .is(accountCriteria.getStatus()));
        }
        if (accountCriteria.getAuctionId() != null) {
            criteria.and(Criteria.where("auction_id")
                    .is(accountCriteria.getAuctionId()));
        }
        if (accountCriteria.getReservedGte() != null) {
            criteria.and(Criteria.where("reserved")
                    .greaterThanEqual(accountCriteria.getReservedGte()));
        }
        if (accountCriteria.getReservedLte() != null) {
            criteria.and(Criteria.where("reserved")
                    .lessThanEqual(accountCriteria.getReservedLte()));
        }
        return new CriteriaQuery(criteria);
    }

}
