package com.cbi.BetOnTrack.model;

public class ThrowPerformance extends Performance {
    private Double distance;
    private Double wind;

    public ThrowPerformance(Integer rank, Double distance, Double wind) {
        super(rank);
        this.distance = distance;
        this.wind = wind;
    }

    public String toString(){
        return distance + " ("+wind+"m/s)";
    }
}
