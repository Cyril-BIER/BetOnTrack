package com.cbi.BetOnTrack.controller;

import com.cbi.BetOnTrack.dto.AthletePerformanceDTO;
import com.cbi.BetOnTrack.dto.CreateCompetition;
import com.cbi.BetOnTrack.dto.CreateCompetitionEvent;
import com.cbi.BetOnTrack.model.Competition;
import com.cbi.BetOnTrack.model.CompetitionEvent;
import com.cbi.BetOnTrack.service.CompetitionEventService;
import com.cbi.BetOnTrack.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition")
public class CompetitionController {
    @Autowired
    CompetitionService competitionService;

    @Autowired
    CompetitionEventService competitionEventService;

    @GetMapping
    public ResponseEntity<List<Competition>> getCompetition(
            @RequestParam(name = "ids",defaultValue = "") List<Long> ids
    ){
        return new ResponseEntity<>(competitionService.getCompetition(ids), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Competition>> postCompetition(
            @RequestBody List<CreateCompetition> competitions
    ){
        return new ResponseEntity<>(competitionService.postCompetition(competitions),HttpStatus.OK);
    }

    @PostMapping("/events")
    public ResponseEntity<List<CompetitionEvent>> postEvents(
            @RequestParam(name="competitionID") Long competitionID,
            @RequestBody List<CreateCompetitionEvent> events
    ){
        return new ResponseEntity<>(competitionService.addEvents(competitionID,events), HttpStatus.OK);
    }

    @PostMapping("/events/addResults")
    public ResponseEntity<CompetitionEvent> postResults(
            @RequestParam(name="competitionEventID") Long competitionEventID,
            @RequestBody List<AthletePerformanceDTO> results
    ){
        return new ResponseEntity<>(competitionEventService.postResults(competitionEventID,results), HttpStatus.OK);
    }
}
