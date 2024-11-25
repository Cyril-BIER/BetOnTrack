package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.CreateEvent;
import com.cbi.BetOnTrack.model.Event;
import com.cbi.BetOnTrack.model.EventGroup;
import com.cbi.BetOnTrack.repository.EventRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {
    @Mock
    EventRepository eventRepository;

    @Mock
    EventGroupService eventGroupService;

    @InjectMocks
    EventService service;

    private static EventGroup distanceRunning;
    private static EventGroup sprint;

    @BeforeAll
    public static void setup(){
        distanceRunning=new EventGroup(1L, "Distance Running");
        sprint=new EventGroup(2L, "Sprint");
    }

    @Test
    public void babyPostEvent(){
        List<Event> expected = List.of(new Event(distanceRunning,"1500m"));
        CreateEvent create1500 = new CreateEvent("1500m",1L);
        when(eventGroupService.getGroups(List.of(1L))).thenReturn(List.of(distanceRunning));
        service.createEvent(List.of(create1500));
        verify(eventRepository).saveAll(expected);
    }

    @Test
    public void multiPostEvent(){
        List<Event> expected = List.of(
                new Event(distanceRunning,"1500m"),
                new Event(sprint, "100m"));
        CreateEvent create1500 = new CreateEvent("1500m",1L);
        CreateEvent create100 = new CreateEvent("100m",2L);

        when(eventGroupService.getGroups(List.of(1L))).thenReturn(List.of(distanceRunning));
        when(eventGroupService.getGroups(List.of(2L))).thenReturn(List.of(sprint));
        service.createEvent(List.of(create1500,create100));
        verify(eventRepository).saveAll(expected);
    }

    @Test
    public void getAllEvents(){
        service.getEvents(List.of());
        verify(eventRepository).findAll();
    }

    @Test
    public void getOneEvent(){
        service.getEvents(List.of(1L));
        verify(eventRepository).findAllById(List.of(1L));
    }

    @Test
    public void getTwoEvents(){
        service.getEvents(List.of(1L,2L));
        verify(eventRepository).findAllById(List.of(1L,2L));
    }
}
