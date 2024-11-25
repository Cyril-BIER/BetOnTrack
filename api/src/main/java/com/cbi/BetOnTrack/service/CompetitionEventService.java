package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.AthletePerformanceDTO;
import com.cbi.BetOnTrack.model.AthletePerformance;
import com.cbi.BetOnTrack.model.CompetitionEvent;
import com.cbi.BetOnTrack.model.RunPerformance;
import com.cbi.BetOnTrack.repository.CompetitionEventRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CompetitionEventService {
    @Autowired
    CompetitionEventRepository competitionEventRepository;

    @Transactional
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
                .collect(Collectors.toCollection(ArrayList::new));
        competitionEvent.setResults(athletePerformances);
        return competitionEventRepository.save(competitionEvent);
    }
}
