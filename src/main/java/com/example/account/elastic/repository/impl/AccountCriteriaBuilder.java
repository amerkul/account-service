package com.example.account.elastic.repository.impl;

import org.springframework.data.elasticsearch.core.query.Criteria;

public final class AccountCriteriaBuilder {

    private final Criteria criteria = new Criteria();

    public Criteria getCriteria(){
        return criteria;
    }

    public AccountCriteriaBuilder containsIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .contains(object.toString()));
        }
        return this;
    }

    public AccountCriteriaBuilder isIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .is(object.toString()));
        }
        return this;
    }

    public AccountCriteriaBuilder greaterThanEqualIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .greaterThanEqual(object.toString()));
        }
        return this;
    }

    public AccountCriteriaBuilder lessThanEqualIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .lessThanEqual(object.toString()));
        }
        return this;
    }

}
