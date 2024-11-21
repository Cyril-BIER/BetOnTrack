package com.cbi.BetOnTrack.controller;

import com.cbi.BetOnTrack.dto.AthleteDTO;
import com.cbi.BetOnTrack.model.Athlete;
import com.cbi.BetOnTrack.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/athlete")
public class AthleteController {
    @Autowired
    AthleteService athleteService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('BOOKMAKER')")
    public ResponseEntity<List<Athlete>> getAthletes(
            @RequestParam(name = "id", defaultValue = "")List<Long>ids
    ){
        return new ResponseEntity<>(athleteService.getAthletes(ids), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('BOOKMAKER')")
    public ResponseEntity<List<Athlete>> postAthletes(
            @RequestBody List<AthleteDTO> athletes
    ){
        return new ResponseEntity<>(athleteService.postAthletes(athletes), HttpStatus.OK);
    }
}
