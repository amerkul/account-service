package com.example.account.property;

import org.springframework.test.context.DynamicPropertyRegistry;

public class TestProperty {

    public static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.elasticsearch.rest.uris", () -> "localhost:9200");
        registry.add("spring.kafka.bootstrap-servers", () -> "localhost:9092");
    }

}
