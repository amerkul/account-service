package com.example.account.config;

import com.example.account.domain.command.UpdateAccountCommand;
import com.example.account.domain.event.AccountCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.sender.SenderOptions;

import java.util.Collections;
import java.util.Map;

@Configuration
public class ReactiveKafkaConfiguration {

    @Value("${spring.kafka.topics.answer}")
    private String topic;
    @Bean
    public ReactiveKafkaProducerTemplate<String, AccountCreatedEvent> reactiveKafkaProducerTemplate(
            KafkaProperties properties) {
        Map<String, Object> props = properties.buildProducerProperties();
        return new ReactiveKafkaProducerTemplate<>(SenderOptions.create(props));
    }

    @Bean
    public ReceiverOptions<String, UpdateAccountCommand> kafkaReceiverOptions(KafkaProperties kafkaProperties) {
        ReceiverOptions<String, UpdateAccountCommand> basicReceiverOptions = ReceiverOptions.create(kafkaProperties.buildConsumerProperties());
        return basicReceiverOptions.subscription(Collections.singletonList(this.topic));
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, UpdateAccountCommand> reactiveKafkaConsumerTemplate(ReceiverOptions<String, UpdateAccountCommand> kafkaReceiverOptions) {
        return new ReactiveKafkaConsumerTemplate<>(kafkaReceiverOptions);
    }

}
