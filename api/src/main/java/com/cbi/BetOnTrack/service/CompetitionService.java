package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.CreateCompetition;
import com.cbi.BetOnTrack.dto.CreateCompetitionEvent;
import com.cbi.BetOnTrack.model.Competition;
import com.cbi.BetOnTrack.model.CompetitionEvent;
import com.cbi.BetOnTrack.repository.CompetitionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService {
    @Autowired
    CompetitionRepository competitionRepository;

    @Autowired
    EventService eventService;

    @Autowired
    AthleteService athleteService;

    public List<Competition> postCompetition(List<CreateCompetition> createCompetitions) {
        List<Competition> competitions = createCompetitions.stream()
                .map(c-> new Competition(c.name(),c.date()))
                .toList();
        return competitionRepository.saveAll(competitions);
    }

    public List<Competition> getCompetition(List<Long> ids) {
        if(ids.isEmpty()) return competitionRepository.findAll();
        return competitionRepository.findAllById(ids);
    }

    @Transactional
    public List<CompetitionEvent> addEvents(Long competitionID, List<CreateCompetitionEvent> events) {
        Competition competition = competitionRepository.findById(competitionID)
                .orElseThrow(EntityNotFoundException::new);
        List<CompetitionEvent> competitionEvents = events.stream()
                .map(e-> new CompetitionEvent(
                        eventService.getEvents(List.of(e.eventID())).getFirst(),
                        e.name(),
                        athleteService.getAthletes(e.startList())))
                .collect(Collectors.toCollection(ArrayList::new));
        competition.addCompetitionEvents(competitionEvents);
        competition = competitionRepository.save(competition);
        return competition.getCompetitionEvents();
    }
}
