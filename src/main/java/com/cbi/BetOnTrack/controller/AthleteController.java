package com.cbi.BetOnTrack.controller;

import com.cbi.BetOnTrack.dto.AthleteDTO;
import com.cbi.BetOnTrack.model.Athlete;
import com.cbi.BetOnTrack.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/athlete")
public class AthleteController {
    @Autowired
    AthleteService athleteService;

    @GetMapping
    public ResponseEntity<List<Athlete>> getAthletes(
            @RequestParam(name = "id", defaultValue = "")List<Long>ids
    ){
        return new ResponseEntity<>(athleteService.getAthletes(ids), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Athlete>> postAthletes(
            @RequestBody List<AthleteDTO> athletes
    ){
        return new ResponseEntity<>(athleteService.postAthletes(athletes), HttpStatus.OK);
    }
}
