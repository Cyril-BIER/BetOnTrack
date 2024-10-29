package com.cbi.BetOnTrack.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CompetitionEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<AthletePerformance> performances;
}
