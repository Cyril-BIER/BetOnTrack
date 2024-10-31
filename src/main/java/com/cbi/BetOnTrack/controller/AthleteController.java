package com.cbi.BetOnTrack.controller;

import com.cbi.BetOnTrack.dto.AthleteDTO;
import com.cbi.BetOnTrack.model.Athlete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/athlete")
public class AthleteController {
    @GetMapping
    public ResponseEntity<List<Athlete>> getAthletes(
            @RequestParam(name = "id", defaultValue = "")List<Integer>ids
    ){
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping
    public ResponseEntity<List<Athlete>> postAthletes(
            @RequestBody List<AthleteDTO> athletes
    ){
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }
}
