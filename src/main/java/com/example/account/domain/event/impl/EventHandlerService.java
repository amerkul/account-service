package com.example.account.domain.event.impl;

import com.example.account.domain.event.EventEntity;
import com.example.account.domain.event.EventHandler;
import com.example.account.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventHandlerService implements EventHandler {

    private final EventRepository eventRepository;

    @Override
    public void handle(EventEntity event) {
        eventRepository.save(event).subscribe();
    }
    
}
