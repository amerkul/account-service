package com.example.account.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
@Table("event")
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Column("event_id")
    private UUID eventId = UUID.randomUUID();
    private LocalDateTime created = LocalDateTime.now();
    private String type;
    private String payload;

    public Event(String type, String payload) {
        this.type = type;
        this.payload = payload;
    }

}
