package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.AthletePerformanceDTO;
import com.cbi.BetOnTrack.model.AthletePerformance;
import com.cbi.BetOnTrack.model.CompetitionEvent;
import com.cbi.BetOnTrack.model.RunPerformance;
import com.cbi.BetOnTrack.repository.CompetitionEventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompetitionEventService {
    @Autowired
    CompetitionEventRepository competitionEventRepository;

    public CompetitionEvent postResults(Long id, List<AthletePerformanceDTO> results) {
        CompetitionEvent competitionEvent = competitionEventRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        List<AthletePerformance> athletePerformances = results.stream()
                .map(e->new AthletePerformance(
                        competitionEvent.getStartList().stream()
                                .filter(c-> Objects.equals(c.getId(), e.getAthleteID()))
                                .findFirst()
                                .orElseThrow(),
                        new RunPerformance(e.getRank(),e.getTimePerformance())
                ))
                .toList();
        competitionEvent.setResults(athletePerformances);
        return competitionEventRepository.save(competitionEvent);
    }
}
