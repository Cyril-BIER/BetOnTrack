package com.cbi.BetOnTrack.dto;

import java.util.List;

public record CreateCompetitionEvent(Long eventID, List<Long> startList) {
}
