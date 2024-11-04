package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.model.EventGroup;
import com.cbi.BetOnTrack.repository.EventGroupRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {
    @Mock
    EventGroupRepository eventGroupRepository;

    @InjectMocks
    EventService service;

    @Test
    public void babyPostGroup(){
        List<EventGroup> expected = List.of(new EventGroup("Distance running"));
        when(eventGroupRepository.saveAll(expected)).thenReturn(expected);
        assertEquals(expected, service.postGroup(List.of("Distance running")));
        verify(eventGroupRepository).saveAll(expected);
    }

    @Test
    public void postGroup(){
        List<EventGroup> expected = List.of(
                new EventGroup("Distance running"),
                new EventGroup("Sprint"));
        when(eventGroupRepository.saveAll(expected)).thenReturn(expected);
        assertEquals(expected, service.postGroup(List.of("Distance running", "Sprint")));
        verify(eventGroupRepository).saveAll(expected);
    }
}