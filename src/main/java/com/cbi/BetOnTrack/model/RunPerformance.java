package com.cbi.BetOnTrack.model;

import jakarta.persistence.Entity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
public class RunPerformance extends Performance{
    private LocalTime time;
    private Double wind;

    public RunPerformance(Integer rank, LocalTime time) {
        super(rank);
        this.time = time;
    }

    public RunPerformance(Integer rank, LocalTime time, Double wind) {
        super(rank);
        this.time = time;
        this.wind = wind;
    }

    public String toString(){
        DateTimeFormatter formatter;

        if (time.getHour() != 0) {
            formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SS");
        } else if (time.getMinute() != 0) {
            formatter = DateTimeFormatter.ofPattern("mm:ss.SS");
        } else {
            formatter = DateTimeFormatter.ofPattern("ss.SS");
        }

        String s = time.format(formatter);

        if (this.wind != null) {
            s += " (" + wind + "m/s)";
        }

        return s;
    }
}
