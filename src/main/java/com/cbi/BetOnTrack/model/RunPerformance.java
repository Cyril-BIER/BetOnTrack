package com.cbi.BetOnTrack.model;

import jakarta.persistence.Entity;

import java.time.LocalTime;

@Entity
public class RunPerformance extends Performance{
    private LocalTime time;
    private Float wind;
}
