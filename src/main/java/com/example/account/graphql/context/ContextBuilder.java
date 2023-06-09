package com.example.account.graphql.context;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilderWithRequest;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class ContextBuilder implements DgsCustomContextBuilderWithRequest<CustomContext> {

    @Override
    public CustomContext build(@Nullable Map<String, ?> extensions, @Nullable HttpHeaders httpHeaders, @Nullable WebRequest webRequest) {
        return new CustomContext("Custom state");
    }

}
