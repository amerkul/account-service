package com.example.account.service.kafka.consumer;

import com.example.account.domain.command.UpdateAccountCommand;
import com.example.account.service.command.CommandService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConsumerService {

    private final ReactiveKafkaConsumerTemplate<String, UpdateAccountCommand> consumerTemplate;
    private final CommandService service;

    @PostConstruct
    public void init() {
        consumerTemplate.receive()
                .subscribe(record -> {
                    service.update(record.value()).subscribe();
                    record.receiverOffset().acknowledge();
                });
    }

}
