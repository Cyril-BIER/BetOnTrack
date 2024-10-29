package com.cbi.BetOnTrack.model;

import jakarta.persistence.*;

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
}
