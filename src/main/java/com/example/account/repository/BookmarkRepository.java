package com.example.account.repository;

import com.example.account.domain.aggregate.Bookmark;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;


public interface BookmarkRepository extends R2dbcRepository<Bookmark, Long> {

    Flux<Bookmark> findBookmarkByAccountId(Long accountId);

}
