package com.cbi.BetOnTrack.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate date;

    @OneToMany
    List<CompetitionEvent> competitionEvents;

    public Competition(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(date, that.date) && Objects.equals(competitionEvents, that.competitionEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, competitionEvents);
    }
}
