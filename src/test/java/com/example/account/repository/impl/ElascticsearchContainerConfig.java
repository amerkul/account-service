package com.example.account.repository.impl;

import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.utility.DockerImageName;

public class ElascticsearchContainerConfig extends ElasticsearchContainer {

    public ElascticsearchContainerConfig() {
        super(DockerImageName.parse("elasticsearch:7.17.10")
                .asCompatibleSubstituteFor(
                        "docker.elastic.co/elasticsearch/elasticsearch")
        );
        this.addFixedExposedPort(9200, 9200);
        this.addEnv("discovery.type", "single-node");
        this.addEnv("xpack.security.enabled", "false");
    }

}
