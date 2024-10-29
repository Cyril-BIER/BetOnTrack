package com.cbi.BetOnTrack.model;

import jakarta.persistence.Entity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
public class RunPerformance extends Performance{
    private LocalTime time;
    private Float wind;

    public RunPerformance(Integer rank, LocalTime time) {
        super(rank);
        this.time = time;
    }

    public String toString(){
        return time.getHour() != 0 ? time.format(DateTimeFormatter.ofPattern("HH:mm:ss.SS")) : time.format(DateTimeFormatter.ofPattern("mm:ss.SS"));

    }
}
