package com.cbi.BetOnTrack.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private EventGroup eventGroup;

    public Event(EventGroup eventGroup, String name) {
        this.eventGroup = eventGroup;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(name, event.name) && Objects.equals(eventGroup, event.eventGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, eventGroup);
    }
}
