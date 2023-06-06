package com.example.account.controller;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.aggregate.BidStatus;
import com.example.account.service.projector.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountReadControllerTest {

    @Mock
    private AccountService service;
    @InjectMocks
    private AccountReadController controller;

    @Test
    void list() {
        AccountAggregate account1 = new AccountAggregate(1L, "k", 5, 5, BidStatus.PENDING, "nkn");
        AccountAggregate account2 = new AccountAggregate(2L, "fdf", 4, 3, BidStatus.PENDING, "dskk");
        AccountAggregate account3 = new AccountAggregate();
        Flux<AccountAggregate> flux = Flux.just(account1, account2, account3);
        when(service.retrieveAll()).thenReturn(flux);
        Flux<AccountAggregate> result = controller.list();
        StepVerifier.create(result)
                .expectNextCount(3)
                .verifyComplete();
    }

}
