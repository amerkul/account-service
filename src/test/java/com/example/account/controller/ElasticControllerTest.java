package com.example.account.controller;

import com.example.account.controller.dto.AccountCriteriaDto;
import com.example.account.elastic.data.Account;
import com.example.account.elastic.service.ElasticAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class ElasticControllerTest {

    @InjectMocks
    ElasticController elasticController;
    @Mock
    ElasticAccountService service;
    @Mock
    ModelMapper mapper;

    @Test
    void getById() {
        Account account = new Account();
        Mockito.when(service.retrieveById(Mockito.anyLong())).thenReturn(Mono.just(account));
        Mono<Account> mono = elasticController.getById(1L);
        StepVerifier.create(mono)
                .expectNext(account)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void getByName() {
        Account account = new Account();
        Mockito.when(service.retrieveByName(Mockito.anyString())).thenReturn(Flux.just(account));
        Flux<Account> flux = elasticController.getByName("cxkmxlk");
        StepVerifier.create(flux)
                .expectNext(account)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void getByBalanceBetween() {
        Account account = new Account();
        Mockito.when(service.retrieveByBalanceBetween(Mockito.anyInt(), Mockito.anyInt())).thenReturn(Flux.just(account));
        Flux<Account> flux = elasticController.getByBalanceBetween(1,2);
        StepVerifier.create(flux)
                .expectNext(account)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void getByQuery() {
        Account account = new Account();
        Mockito.when(service.retrieveByParams(Mockito.any(), Mockito.any())).thenReturn(Flux.just(account));
        Flux<Account> flux = elasticController.getByQuery(1, 2, new AccountCriteriaDto());
        StepVerifier.create(flux)
                .expectNext(account)
                .expectNextCount(0)
                .verifyComplete();
    }

}
