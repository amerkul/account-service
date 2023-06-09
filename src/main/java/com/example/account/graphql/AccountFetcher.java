package com.example.account.graphql;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.aggregate.Bookmark;
import com.example.account.domain.aggregate.filter.AccountFilter;
import com.example.account.graphql.context.CustomContext;
import com.example.account.service.BookmarkService;
import com.example.account.service.projector.AccountService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.reactive.internal.DgsReactiveRequestData;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;

@DgsComponent
@AllArgsConstructor
public class AccountFetcher {

    private final AccountService accountService;
    private final BookmarkService bookmarkService;

    @DgsQuery
    public Flux<AccountAggregate> accounts(@InputArgument AccountFilter filter) {
        return accountService.retrieveAllByFilter(filter);
    }

    @DgsData(parentType = "AccountAggregate", field = "bookmarks")
    public Flux<Bookmark> bookmarks(DgsDataFetchingEnvironment dfe) {
        AccountAggregate account = dfe.getSource();
        return bookmarkService.retrieveByAccountId(account.getAccountId());
    }

    @DgsQuery
    public String host(@RequestHeader String host) {
        return host;
    }

    @DgsQuery
    public String cookie(@CookieValue(defaultValue = "defaultValue") String cookie) {
        return cookie;
    }

    @DgsMutation
    public String updateCookie(@InputArgument String value, DgsDataFetchingEnvironment dfe) {
        DgsReactiveRequestData requestData = (DgsReactiveRequestData) dfe.getDgsContext().getRequestData();
        ServerRequest serverRequest = requestData.getServerRequest();
        ServerHttpResponse response = serverRequest.exchange().getResponse();
        response.addCookie(ResponseCookie.from("mydgscookie", value).build());
        return response.getCookies().toString();
    }

    @DgsQuery
    public String customContextState(DgsDataFetchingEnvironment dfe) {
        CustomContext context = DgsContext.getCustomContext(dfe);
        return context.getState();
    }

}
