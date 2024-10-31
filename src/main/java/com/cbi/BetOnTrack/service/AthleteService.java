package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.model.Athlete;
import com.cbi.BetOnTrack.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {
    @Autowired
    AthleteRepository athleteRepository;

    public List<Athlete> getAthletes(List<Long> ids) {
        return athleteRepository.findAllById(ids);
    }
}
