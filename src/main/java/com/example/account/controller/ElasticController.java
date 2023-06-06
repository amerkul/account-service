package com.example.account.controller;

import com.example.account.controller.dto.AccountCriteriaDto;
import com.example.account.domain.data.Account;
import com.example.account.domain.data.criteria.AccountCriteria;
import com.example.account.service.ElasticAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/account-index")
public class ElasticController {

    private final ElasticAccountService service;
    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public Mono<Account> getById(@PathVariable("id") long id) {
        log.debug("Started getById method with account id={}", id);
        return service.retrieveById(id);
    }

    @GetMapping("/name/{name}")
    public Flux<Account> getByName(@PathVariable("name") String name) {
        log.debug("Started getByName method with account name={}", name);
        return service.retrieveByName(name);
    }

    @GetMapping("/balance")
    public Flux<Account> getByBalanceBetween(@RequestParam("from") int from,
                                             @RequestParam("to") int to) {
        log.debug("Started getByBalanceBetween method with account balance");
        return service.retrieveByBalanceBetween(from, to);
    }

    @GetMapping("/query")
    public Flux<Account> getByQuery(@RequestParam("page") int page,
                                    @RequestParam("size") int size,
                                    final AccountCriteriaDto accountCriteriaDto) {
        log.debug("Started getByQuery method with account query");
        AccountCriteria accountCriteria = mapper.map(accountCriteriaDto, AccountCriteria.class);
        return service.retrieveByParams(accountCriteria, PageRequest.of(page, size));
    }

}
