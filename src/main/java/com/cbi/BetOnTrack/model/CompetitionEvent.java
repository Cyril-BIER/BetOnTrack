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


    private String name;

    @ManyToOne
    private Event event;

    @ManyToMany
    private List<Athlete> startList;

    @OneToMany
    private List<AthletePerformance> performances;

    public CompetitionEvent(){}

    public CompetitionEvent(Event event, String name ,List<Athlete> startList) {
        this.event = event;
        this.name = name;
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

    public void setResults(List<AthletePerformance> performances) {
        this.performances = performances;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Event getEvent() {
        return event;
    }

    public List<Athlete> getStartList() {
        return startList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitionEvent that = (CompetitionEvent) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(event, that.event) && Objects.equals(startList, that.startList) && Objects.equals(performances, that.performances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, event, startList, performances);
    }
}
