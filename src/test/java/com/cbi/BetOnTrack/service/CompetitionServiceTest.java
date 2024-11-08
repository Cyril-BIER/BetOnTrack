package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.CreateCompetition;
import com.cbi.BetOnTrack.dto.CreateCompetitionEvent;
import com.cbi.BetOnTrack.model.*;
import com.cbi.BetOnTrack.repository.CompetitionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompetitionServiceTest {
    @Mock
    CompetitionRepository competitionRepository;

    @Mock
    EventService eventService;

    @Mock
    AthleteService athleteService;

    @InjectMocks
    CompetitionService service;

    private static Event distance1500;
    private static Event distance100;

    @BeforeAll
    public static void setup(){
        EventGroup distanceRunning = new EventGroup(1L, "Distance Running");
        EventGroup sprint = new EventGroup(2L, "Sprint");
        distance1500 = new Event(distanceRunning,"1500m");
        distance100 = new Event(sprint,"100m");
    }

    @Test
    public void babyPostCompetition(){
        Competition parameter = new Competition("Olympic Games", LocalDate.of(2024,8,1));
        service.postCompetition(List.of(
                new CreateCompetition("Olympic Games", LocalDate.of(2024,8,1)))
        );
        verify(competitionRepository).saveAll(List.of(parameter));
    }

    @Test
    public void postCompetition(){
        List<Competition> parameter =List.of(
                new Competition("Olympic Games", LocalDate.of(2024,8,1)),
                new Competition("Diamond League Final", LocalDate.of(2024,8,1)));
        service.postCompetition(List.of(
                new CreateCompetition("Olympic Games", LocalDate.of(2024,8,1)),
                new CreateCompetition("Diamond League Final", LocalDate.of(2024,8,1)))
        );
        verify(competitionRepository).saveAll(parameter);
    }

    @Test
    public void babyGetCompetition(){
        service.getCompetition(List.of(1L));
        verify(competitionRepository).findAllById(List.of(1L));
    }

    @Test
    public void getCompetition(){
        service.getCompetition(List.of(1L, 2L));
        verify(competitionRepository).findAllById(List.of(1L, 2L));
    }

    @Test
    public void getAllCompetition(){
        service.getCompetition(List.of());
        verify(competitionRepository).findAll();
    }

    @Test
    public void babyAddEvents(){
        Competition expected = new Competition("Olympics",LocalDate.of(2024,8,1));
        Athlete jakob = new Athlete(1L,"Jakob","Ingerbritsen");
        CompetitionEvent competitionEvent = new CompetitionEvent(distance1500,"Final",List.of(jakob));
        expected.setCompetitionEvents(List.of(competitionEvent));

        when(competitionRepository.findById(1L)).thenReturn(Optional.of(new Competition("Olympics",LocalDate.of(2024,8,1))));
        when(eventService.getEvents(List.of(1L))).thenReturn(List.of(distance1500));
        when(athleteService.getAthletes(List.of(1L))).thenReturn(List.of(jakob));
        when(competitionRepository.save(expected)).thenReturn(expected);

        service.addEvents(1L, List.of(
                new CreateCompetitionEvent(1L,"Final",List.of(1L))
        ));
        verify(competitionRepository).save(expected);
    }

    @Test
    public void addOneMoreEvent(){
        Competition existingComp = new Competition("Olympics",LocalDate.of(2024,8,1));
        Athlete jakob = new Athlete(1L,"Jakob","Ingerbritsen");
        CompetitionEvent competitionEvent1 = new CompetitionEvent(distance1500,"Final",List.of(jakob));
        List<CompetitionEvent> competitionEvents = new ArrayList<>();
        competitionEvents.add(competitionEvent1);
        existingComp.setCompetitionEvents(competitionEvents);
        when(competitionRepository.findById(1L)).thenReturn(Optional.of(existingComp));

        Athlete noah = new Athlete(2L,"Noah","Lyles");
        CompetitionEvent competitionEvent2 = new CompetitionEvent(distance100,"Final",List.of(noah));

        Competition expected = new Competition("Olympics",LocalDate.of(2024,8,1));
        expected.setCompetitionEvents(Arrays.asList(competitionEvent1, competitionEvent2));

        when(eventService.getEvents(List.of(2L))).thenReturn(List.of(distance100));
        when(athleteService.getAthletes(List.of(2L))).thenReturn(List.of(noah));
        when(competitionRepository.save(expected)).thenReturn(expected);

        service.addEvents(1L, List.of(
                new CreateCompetitionEvent(2L,"Final",List.of(2L))
        ));
        verify(competitionRepository).save(expected);
    }
}