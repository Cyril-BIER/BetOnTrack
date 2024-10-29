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
}
