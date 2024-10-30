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
        String s;
        if (time.getHour() != 0) s = time.format(DateTimeFormatter.ofPattern("HH:mm:ss.SS"));
        if (time.getMinute() != 0) {
            s= time.format(DateTimeFormatter.ofPattern("mm:ss.SS"));
        }else{
            s = time.format(DateTimeFormatter.ofPattern("ss.SS"));
        }
        if(this.wind != null){
            s +=" ("+wind +"m/s)";
        }
        return s;
    }
}
