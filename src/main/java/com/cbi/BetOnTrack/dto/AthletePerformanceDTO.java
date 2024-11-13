package com.cbi.BetOnTrack.dto;

import java.time.LocalTime;

public class AthletePerformanceDTO {
    private final Integer rank;
    private final Long athleteID;
    private LocalTime timePerformance;
    private Double distancePerformance;

    public AthletePerformanceDTO(Integer rank, Long athleteID, LocalTime timePerformance) {
        this.rank = rank;
        this.athleteID = athleteID;
        this.timePerformance = timePerformance;
    }

    public AthletePerformanceDTO(Integer rank, Long athleteID, Double distance) {
        this.rank = rank;
        this.athleteID = athleteID;
        this.distancePerformance = distance;
    }

    public Integer getRank() {
        return this.rank;
    }

    public Long getAthleteID() {
        return this.athleteID;
    }

    public LocalTime getTimePerformance() {
        return this.timePerformance;
    }

    public Double getDistancePerformance() {
        return this.distancePerformance;
    }
}
