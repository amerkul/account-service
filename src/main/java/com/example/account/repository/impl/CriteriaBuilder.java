package com.example.account.repository.impl;

import org.springframework.data.elasticsearch.core.query.Criteria;

public final class CriteriaBuilder {

    private final Criteria criteria = new Criteria();

    public Criteria getCriteria(){
        return criteria;
    }

    public CriteriaBuilder containsIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .contains(object.toString()));
        }
        return this;
    }

    public CriteriaBuilder isIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .is(object.toString()));
        }
        return this;
    }

    public CriteriaBuilder greaterThanEqualIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .greaterThanEqual(object.toString()));
        }
        return this;
    }

    public CriteriaBuilder lessThanEqualIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .lessThanEqual(object.toString()));
        }
        return this;
    }

}
