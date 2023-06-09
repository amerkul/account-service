package com.example.account.graphql;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.aggregate.BidStatus;
import com.example.account.domain.aggregate.Bookmark;
import com.example.account.graphql.context.ContextBuilder;
import com.example.account.service.BookmarkService;
import com.example.account.service.projector.AccountService;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {DgsAutoConfiguration.class, AccountFetcher.class, ContextBuilder.class})
class AccountFetcherTest {

    @Autowired
    DgsQueryExecutor executor;

    @MockBean
    AccountService accountService;
    @MockBean
    BookmarkService bookmarkService;

    @Test
    void accounts() {
        AccountAggregate accountAggregate = new AccountAggregate(
                1L, "Name", 1, 1, BidStatus.ACCEPTED, "8g8"
        );
        when(accountService.retrieveAllByFilter(null))
                .thenReturn(Flux.just(accountAggregate));
        List<String> names = executor.executeAndExtractJsonPath(
                " {accounts {name}}", "data.accounts[*].name"
        );
        assertEquals(1, names.size());
        verify(accountService).retrieveAllByFilter(null);
    }

    @Test
    void bookmarks() {
        AccountAggregate accountAggregate = new AccountAggregate(
                1L, "Name", 1, 1, BidStatus.ACCEPTED, "8g8"
        );
        when(accountService.retrieveAllByFilter(null))
                .thenReturn(Flux.just(accountAggregate));
        when(bookmarkService.retrieveByAccountId(Mockito.anyLong()))
                .thenReturn(Flux.just(new Bookmark(1L, "Title", 2020, 1L)));
        List<String> names = executor.executeAndExtractJsonPath(
                " {accounts {name bookmarks {title}}}", "data.accounts[*].name"
        );
        assertEquals(1, names.size());
        verify(accountService).retrieveAllByFilter(null);
        verify(bookmarkService).retrieveByAccountId(Mockito.anyLong());
    }

    @Test
    void customContextState() {
        String state = executor.executeAndExtractJsonPath(
                " {customContextState}", "data.customContextState"
        );
        assertEquals("Custom state", state);
    }

}
