package com.example.account.repository;

import com.example.account.aggregate.AccountAggregate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AccountRepository extends R2dbcRepository<AccountAggregate, Long> {

}
