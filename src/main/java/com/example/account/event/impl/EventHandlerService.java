package com.example.account.event.impl;

import com.example.account.event.EventEntity;
import com.example.account.event.EventHandler;
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
