package com.example.account.kafka.config;

import com.example.account.command.UpdateAccountCommand;
import com.example.account.event.AccountCreatedEvent;
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

    @Bean
    public ReactiveKafkaProducerTemplate<String, AccountCreatedEvent> reactiveKafkaProducerTemplate(
            KafkaProperties properties) {
        Map<String, Object> props = properties.buildProducerProperties();
        return new ReactiveKafkaProducerTemplate<>(SenderOptions.create(props));
    }

    @Bean
    public ReceiverOptions<String, UpdateAccountCommand> kafkaReceiverOptions(@Value("${spring.kafka.topics.answer}") String topic, KafkaProperties kafkaProperties) {
        ReceiverOptions<String, UpdateAccountCommand> basicReceiverOptions = ReceiverOptions.create(kafkaProperties.buildConsumerProperties());
        return basicReceiverOptions.subscription(Collections.singletonList(topic));
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, UpdateAccountCommand> reactiveKafkaConsumerTemplate(ReceiverOptions<String, UpdateAccountCommand> kafkaReceiverOptions) {
        return new ReactiveKafkaConsumerTemplate<>(kafkaReceiverOptions);
    }

}
