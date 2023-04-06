package com.example.account.kafka.consumer;

import com.example.account.command.UpdateAccountCommand;
import com.example.account.service.command.CommandService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReactiveKafkaConsumer {

    private final ReactiveKafkaConsumerTemplate<String, UpdateAccountCommand> consumerTemplate;
    private final CommandService service;

    @PostConstruct
    public void init() {
        consumerTemplate.receive()
                        .subscribe(record -> {
                            service.update(record.value());
                            record.receiverOffset()
                                      .acknowledge();
                        });
    }

}
