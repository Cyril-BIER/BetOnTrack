package com.cbi.BetOnTrack.model;

import com.cbi.BetOnTrack.dto.AthleteResult;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
public class CompetitionEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Event event;

    @OneToMany
    private List<AthletePerformance> performances;

    public CompetitionEvent(Event event) {
        this.event = event;
        performances = new ArrayList<>();
    }

    public CompetitionEvent(Event event, List<AthletePerformance> performances) {
        this.event = event;
        this.performances = performances;
    }

    public List<AthleteResult> getResult() {
        return performances.stream()
                .map(p->new AthleteResult(
                        p.getPerformance().getRank(),
                        p.getAthlete().getFirstName(),
                        p.getAthlete().getlastName(),
                        p.getPerformance().toString()))
                .sorted(Comparator.comparingInt(AthleteResult::rank))
                .toList();

    }
}
