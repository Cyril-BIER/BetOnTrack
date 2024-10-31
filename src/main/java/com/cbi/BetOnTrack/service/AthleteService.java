package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.AthleteDTO;
import com.cbi.BetOnTrack.model.Athlete;
import com.cbi.BetOnTrack.repository.AthleteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {
    @Autowired
    AthleteRepository athleteRepository;

    public List<Athlete> getAthletes(List<Long> ids) {
        if (ids.isEmpty()) return athleteRepository.findAll();
        return athleteRepository.findAllById(ids);
    }

    @Transactional
    public List<Athlete> postAthletes(List<AthleteDTO> athletesDTO) {
        List<Athlete> athletes = athletesDTO.stream()
                .map(a-> new Athlete(a.firstName(),a.LastName()))
                .toList();
        return athleteRepository.saveAll(athletes);
    }
}
