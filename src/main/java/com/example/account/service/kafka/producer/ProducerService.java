package com.example.account.service.kafka.producer;

import com.example.account.domain.event.AccountCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProducerService {

    private final ReactiveKafkaProducerTemplate<String, AccountCreatedEvent> reactiveKafkaProducerTemplate;

    @Value("${spring.kafka.topics.bid}")
    private String topic;

    public ProducerService(ReactiveKafkaProducerTemplate<String, AccountCreatedEvent> reactiveKafkaProducerTemplate) {
        this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
    }

    public void send(AccountCreatedEvent event) {
        reactiveKafkaProducerTemplate.send(topic, event).subscribe();
        log.debug("Sent event: " + event);
    }

}
