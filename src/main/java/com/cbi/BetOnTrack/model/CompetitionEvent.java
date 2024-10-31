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

    @ManyToOne
    private final Event event;

    @OneToMany
    private List<Athlete> startList;

    @OneToMany
    private List<AthletePerformance> performances;

    public CompetitionEvent(Event event, List<Athlete> startList) {
        this.event = event;
        this.startList = startList;
        performances = new ArrayList<>();
    }

    public List<AthleteResult> getResult() {
        return performances.stream()
                .map(p->new AthleteResult(
                        p.getPerformance().getRank(),
                        p.getAthlete().getFirstName(),
                        p.getAthlete().getLastName(),
                        p.getPerformance().toString()))
                .sorted(Comparator.comparingInt(AthleteResult::rank))
                .toList();

    }

    public List<Athlete> getStartList() {
        return this.startList;
    }

    public void addResults(List<AthletePerformance> performances) {
        this.performances = performances;
    }
}
