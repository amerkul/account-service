package com.example.account.kafka.consumer;

import com.example.account.aggregate.AccountAggregate;
import com.example.account.command.UpdateAccountCommand;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReactiveKafkaConsumer {

    private final ReactiveKafkaConsumerTemplate<String, UpdateAccountCommand> consumerTemplate;
    private final AccountAggregate service;

    @PostConstruct
    public void init() {
        consumerTemplate.receive()
                        .subscribe(record -> {
                            service.update(record.value()).subscribe();
                            record.receiverOffset()
                                      .acknowledge();
                        });
    }

}
