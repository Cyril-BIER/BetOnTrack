package com.cbi.BetOnTrack.model;

import jakarta.persistence.Entity;

@Entity
public class HighJumpPerformance extends Performance{
    public HighJumpPerformance(Integer rank) {
        super(rank);
    }
}
