package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.CreateCompetition;
import com.cbi.BetOnTrack.model.Competition;
import com.cbi.BetOnTrack.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    CompetitionRepository competitionRepository;

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
}
