package com.cbi.BetOnTrack.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class EventGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany
    private List<Event> events;

    public EventGroup(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventGroup that = (EventGroup) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(events, that.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, events);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
