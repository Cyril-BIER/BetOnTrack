package com.cbi.BetOnTrack.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;

    @OneToMany
    List<CompetitionEvent> competitionEvents;
}
