package com.example.account.service.impl;

import com.example.account.domain.aggregate.Bookmark;
import com.example.account.repository.BookmarkRepository;
import com.example.account.service.BookmarkService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@AllArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository repository;

    @Override
    public Flux<Bookmark> retrieveByAccountId(Long accountId) {
        log.debug("Retrieving bookmarks by account id = {}...", accountId);
        return repository.findBookmarkByAccountId(accountId);
    }

}
