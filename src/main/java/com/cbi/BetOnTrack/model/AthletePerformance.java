package com.cbi.BetOnTrack.model;

import jakarta.persistence.*;

@Entity
public class AthletePerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Athlete athlete;

    @OneToOne
    private Performance performance;

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
}
