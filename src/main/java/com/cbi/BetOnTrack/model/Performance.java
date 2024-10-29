package com.cbi.BetOnTrack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer rank;

    public Performance(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank() {
        return this.rank;
    }
}
