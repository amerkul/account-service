package com.example.account.repository;

import com.example.account.domain.aggregate.AccountAggregate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AccountRepository extends R2dbcRepository<AccountAggregate, Long>, R2dbcAccountCriteriaRepository {

}
