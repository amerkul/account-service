package com.example.account.repository.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.query.Criteria;

import static org.springframework.data.relational.core.query.Criteria.where;

@AllArgsConstructor
public class R2dbcCriteriaBuilder {

    private Criteria criteria;

    public R2dbcCriteriaBuilder containsColumn(Object object, String column) {
        if (object != null) {
            criteria.and(where(column).is(object));
        }
        return this;
    }

    public Criteria getCriteria() {
        return criteria;
    }

}
