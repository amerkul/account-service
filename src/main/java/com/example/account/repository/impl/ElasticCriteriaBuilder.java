package com.example.account.repository.impl;

import org.springframework.data.elasticsearch.core.query.Criteria;

public record ElasticCriteriaBuilder(Criteria criteria) {

    public ElasticCriteriaBuilder containsIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .contains(object.toString()));
        }
        return this;
    }

    public ElasticCriteriaBuilder isIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .is(object.toString()));
        }
        return this;
    }

    public ElasticCriteriaBuilder greaterThanEqualIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .greaterThanEqual(object.toString()));
        }
        return this;
    }

    public ElasticCriteriaBuilder lessThanEqualIfNotNull(Object object, String field) {
        if (object != null) {
            criteria.and(Criteria.where(field)
                    .lessThanEqual(object.toString()));
        }
        return this;
    }

}
