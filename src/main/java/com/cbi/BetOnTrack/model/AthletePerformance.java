package com.cbi.BetOnTrack.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AthletePerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Athlete athlete;

    @OneToOne(cascade = CascadeType.ALL)
    private Performance performance;

    public AthletePerformance(){}

    public AthletePerformance(Athlete athlete, Performance performance) {
        this.athlete = athlete;
        this.performance = performance;
    }

    public Performance getPerformance() {
        return this.performance;
    }

    public Athlete getAthlete() {
        return this.athlete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AthletePerformance that = (AthletePerformance) o;
        return Objects.equals(id, that.id) && Objects.equals(athlete, that.athlete) && Objects.equals(performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, athlete, performance);
    }
}
