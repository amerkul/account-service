package com.example.account.service.impl;

import com.example.account.domain.data.Account;
import com.example.account.domain.data.criteria.AccountCriteria;
import com.example.account.repository.ElasticAccountRepository;
import com.example.account.service.ElasticAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElasticAccountServiceImpl implements ElasticAccountService {

    private final ElasticAccountRepository elasticAccountRepository;

    @Override
    public Mono<Account> retrieveById(long id) {
        log.debug("Retrieving account by id={}", id);
        return elasticAccountRepository.findById(id).log();
    }

    @Override
    public Flux<Account> retrieveByName(String name) {
        log.debug("Retrieving account by name={}", name);
        return elasticAccountRepository.findAccountByName(name);
    }

    @Override
    public Flux<Account> retrieveByBalanceBetween(int from, int to) {
        log.debug("Retrieving account by balance between {} and {}", from, to);
        return elasticAccountRepository.findAccountByBalanceBetween(from, to);
    }

    @Override
    public Flux<Account> retrieveByParams(AccountCriteria criteria, Pageable pageable) {
        log.debug("Account criteria: " + criteria);
        return elasticAccountRepository.findByCriteria(criteria, pageable);
    }

}
