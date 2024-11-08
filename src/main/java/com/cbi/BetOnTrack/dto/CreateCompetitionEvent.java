package com.cbi.BetOnTrack.dto;

import java.util.List;

public record CreateCompetitionEvent(Long eventID,String name ,List<Long> startList) {
}
