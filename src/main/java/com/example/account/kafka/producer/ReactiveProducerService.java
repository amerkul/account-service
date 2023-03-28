package com.example.account.kafka.producer;

import com.example.account.event.AccountCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReactiveProducerService {

    private final ReactiveKafkaProducerTemplate<String, AccountCreatedEvent> reactiveKafkaProducerTemplate;

    @Value("${spring.kafka.topics.bid}")
    private String topic;

    public ReactiveProducerService(ReactiveKafkaProducerTemplate<String, AccountCreatedEvent> reactiveKafkaProducerTemplate) {
        this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
    }

    public void send(AccountCreatedEvent event) {
        reactiveKafkaProducerTemplate.send(topic, event).subscribe();
        log.debug("Sent event: " + event);
    }

}
