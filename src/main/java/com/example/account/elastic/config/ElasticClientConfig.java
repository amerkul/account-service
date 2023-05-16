package com.example.account.elastic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration;

@Configuration
public class ElasticClientConfig extends ReactiveElasticsearchConfiguration {

    @Value("${elastic.host}")
    private String elasticHost;

    @Value("${elastic.port}")
    private Integer elasticPort;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(String.format("%s:%d", elasticHost, elasticPort))
                .build();
    }

}
