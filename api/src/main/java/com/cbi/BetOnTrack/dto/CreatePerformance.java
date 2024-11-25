package com.cbi.BetOnTrack.dto;

import java.time.LocalTime;

public record CreatePerformance(Long athleteID, LocalTime timePerformance, Double distancePerformance) {
}
