package com.example.account.repository.impl;

import com.example.account.property.TestProperty;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class BaseElasticDockerConfiguration {

    static final DockerImageName IMAGE_NAME = DockerImageName.parse("elasticsearch:7.17.10")
            .asCompatibleSubstituteFor("docker.elastic.co/elasticsearch/elasticsearch");

    @Container
    static ElasticsearchContainer elastic = new ElascticsearchContainerConfig(IMAGE_NAME)
            .addDefaultProperties();

    @DynamicPropertySource
    static void init(DynamicPropertyRegistry registry) {
        TestProperty.setProperties(registry);
    }

    @BeforeAll
    static void create() {
        elastic.start();
    }

    @AfterAll
    static void destroy() {
        elastic.stop();
    }

}
