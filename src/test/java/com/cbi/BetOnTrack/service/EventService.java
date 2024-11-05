package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.CreateEvent;
import com.cbi.BetOnTrack.model.Event;
import com.cbi.BetOnTrack.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventGroupService eventGroupService;

    public List<Event> createEvent(List<CreateEvent> createEvents) {

        List<Event> events = createEvents.stream()
                .map(e-> new Event(
                    eventGroupService.getGroups(List.of(e.groupID())).getFirst(),
                    e.name()))
                .toList();
        return eventRepository.saveAll(events);
    }
}
