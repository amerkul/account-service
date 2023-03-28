package com.example.account.repository;

import com.example.account.event.AccountCreatedEvent;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AccountCreatedRepository extends R2dbcRepository<AccountCreatedEvent, Long> {
}
