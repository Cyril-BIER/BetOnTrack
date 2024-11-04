package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.model.EventGroup;
import com.cbi.BetOnTrack.repository.EventGroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventGroupRepository eventGroupRepository;

    @Transactional
    public List<EventGroup> postGroup(List<String> names) {
        List<EventGroup> eventGroups = names.stream().map(EventGroup::new).toList();
        return eventGroupRepository.saveAll(eventGroups);
    }

    public List<EventGroup> getGroups(List<Long> ids) {
        if(ids.isEmpty()) return eventGroupRepository.findAll();
        return eventGroupRepository.findAllById(ids);
    }
}
