package com.cbi.BetOnTrack.model;

import com.cbi.BetOnTrack.dto.AthleteResult;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Entity
public class CompetitionEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Event event;

    @ManyToMany
    private List<Athlete> startList;

    @OneToMany
    private List<AthletePerformance> performances;

    public CompetitionEvent(){}

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

    public void addResults(List<AthletePerformance> performances) {
        this.performances = performances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitionEvent that = (CompetitionEvent) o;
        return Objects.equals(id, that.id) && Objects.equals(event, that.event) && Objects.equals(startList, that.startList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, event, startList);
    }

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public List<Athlete> getStartList() {
        return startList;
    }
}
