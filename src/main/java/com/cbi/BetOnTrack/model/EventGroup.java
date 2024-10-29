package com.cbi.BetOnTrack.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class EventGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    private List<Event> events;

    public EventGroup(String name) {
        this.name = name;
    }
}
