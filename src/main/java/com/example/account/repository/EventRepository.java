package com.example.account.repository;

import com.example.account.event.Event;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface EventRepository extends R2dbcRepository<Event, Long> {

}
