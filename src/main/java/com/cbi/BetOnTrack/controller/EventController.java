package com.cbi.BetOnTrack.controller;

import com.cbi.BetOnTrack.model.Event;
import com.cbi.BetOnTrack.model.EventGroup;
import com.cbi.BetOnTrack.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/group")
    public ResponseEntity<List<EventGroup>> getGroup(
            @RequestParam(name = "ids",defaultValue = "") List<Long> ids){
        return new ResponseEntity<>(eventService.getGroups(ids), HttpStatus.OK);
    }

    @PostMapping("/group")
    public ResponseEntity<List<EventGroup>> postGroup(
            @RequestParam(name = "names") List<String> names
    ){
        List<EventGroup> groups = eventService.postGroup(names);
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Event> getEvent(List<Long> ids){
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping
    public ResponseEntity<Event> postEvent(List<Event> events){
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }
}
