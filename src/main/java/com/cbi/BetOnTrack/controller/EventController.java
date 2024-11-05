package com.cbi.BetOnTrack.controller;

import com.cbi.BetOnTrack.dto.CreateEvent;
import com.cbi.BetOnTrack.model.Event;
import com.cbi.BetOnTrack.model.EventGroup;
import com.cbi.BetOnTrack.service.EventGroupService;
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
    EventGroupService eventGroupService;

    @Autowired
    EventService eventService;

    @GetMapping("/group")
    public ResponseEntity<List<EventGroup>> getGroup(
            @RequestParam(name = "ids",defaultValue = "") List<Long> ids){
        return new ResponseEntity<>(eventGroupService.getGroups(ids), HttpStatus.OK);
    }

    @PostMapping("/group")
    public ResponseEntity<List<EventGroup>> postGroup(
            @RequestParam(name = "names") List<String> names
    ){
        List<EventGroup> groups = eventGroupService.postGroup(names);
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvent(
            @RequestParam(name = "ids", defaultValue = "") List<Long> ids){
        return new ResponseEntity<>(eventService.getEvents(ids), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Event>> postEvent(
            @RequestBody List<CreateEvent> events){
        return new ResponseEntity<>(eventService.createEvent(events), HttpStatus.OK);
    }
}
