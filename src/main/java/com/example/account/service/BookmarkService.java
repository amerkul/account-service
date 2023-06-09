package com.example.account.service;

import com.example.account.domain.aggregate.Bookmark;
import reactor.core.publisher.Flux;

public interface BookmarkService {

    Flux<Bookmark> retrieveByAccountId(Long accountId);

}
