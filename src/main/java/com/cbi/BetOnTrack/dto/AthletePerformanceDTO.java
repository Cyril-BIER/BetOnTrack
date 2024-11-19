package com.cbi.BetOnTrack.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public class AthletePerformanceDTO {
    private Integer rank;
    private Long athleteID;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss.SSS")
    private LocalTime timePerformance;
    private Double distancePerformance;

    public AthletePerformanceDTO(){}

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
