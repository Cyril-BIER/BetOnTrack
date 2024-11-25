package com.cbi.BetOnTrack.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
public class RunPerformance extends Performance{
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss.SSS")
    @Column(columnDefinition = "TIMESTAMP")
    private LocalTime time;
    private Double wind;

    public RunPerformance(){super();}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunPerformance that = (RunPerformance) o;
        return Objects.equals(time, that.time) && Objects.equals(wind, that.wind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, wind);
    }
}
