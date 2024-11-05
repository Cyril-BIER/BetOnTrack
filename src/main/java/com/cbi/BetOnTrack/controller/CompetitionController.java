package com.cbi.BetOnTrack.controller;

import com.cbi.BetOnTrack.dto.CreateCompetition;
import com.cbi.BetOnTrack.dto.CreateCompetitionEvent;
import com.cbi.BetOnTrack.dto.CreatePerformance;
import com.cbi.BetOnTrack.model.Competition;
import com.cbi.BetOnTrack.model.CompetitionEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition")
public class CompetitionController {
    @GetMapping
    public ResponseEntity<List<Competition>> getCompetition(
            @RequestParam(name = "ids",defaultValue = "") List<Long> ids
    ){
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping
    public ResponseEntity<List<Competition>> postCompetition(
            @RequestBody List<CreateCompetition> competitions
    ){
        return new ResponseEntity<>(null,HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/events")
    public ResponseEntity<Competition> postEvents(
            @RequestParam(name="competitionID") Long competitionID,
            @RequestBody List<CreateCompetitionEvent> events
    ){
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/events/addResults")
    public ResponseEntity<CompetitionEvent> postResults(
            @RequestParam(name="competitionEventID") Long competitionEventID,
            @RequestBody List<CreatePerformance> events
    ){
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }
}
