package com.example.account.repository.impl;

import com.example.account.property.TestProperty;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class BaseElasticDockerConfiguration {

    @Container
    static ElasticsearchContainer elastic = new ElascticsearchContainerConfig();

    @DynamicPropertySource
    static void init(DynamicPropertyRegistry registry) {
        TestProperty.setProperties(registry);
    }

    @BeforeAll
    static void create(){
        elastic.start();
    }

    @AfterAll
    static void destroy() {
        elastic.stop();
    }

}
