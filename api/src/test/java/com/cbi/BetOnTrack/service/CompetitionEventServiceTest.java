package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.AthletePerformanceDTO;
import com.cbi.BetOnTrack.model.*;
import com.cbi.BetOnTrack.repository.CompetitionEventRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompetitionEventServiceTest {
    @Mock
    CompetitionEventRepository competitionEventRepository;

    @InjectMocks
    CompetitionEventService service;

    private static Event distance1500;

    @BeforeAll
    public static void setup(){
        EventGroup distanceRunning = new EventGroup(1L, "Distance Running");
        distance1500 = new Event(distanceRunning,"1500m");
    }
    @Test
    public void addResultTest(){
        Athlete jakob = new Athlete(1L,"Jakob","Ingerbritsen");
        Athlete josh = new Athlete(2L,"Josh","Kerr");
        Athlete cole = new Athlete(3L,"Cole","Hawker");

        CompetitionEvent competitionEvent = new CompetitionEvent(distance1500,"Final", List.of(jakob, josh, cole));

        CompetitionEvent expected = new CompetitionEvent(distance1500,"Final", List.of(jakob, josh, cole));
        AthletePerformance colePerformance = new AthletePerformance(cole,new RunPerformance(1, LocalTime.of(0,3,29,0)));
        AthletePerformance joshPerformance = new AthletePerformance(josh,new RunPerformance(2, LocalTime.of(0,3,29,5000000)));
        AthletePerformance jakobPerformance = new AthletePerformance(jakob,new RunPerformance(3, LocalTime.of(0,3,30,0)));
        expected.setResults(List.of(colePerformance,joshPerformance,jakobPerformance));

        when(competitionEventRepository.findById(null)).thenReturn(Optional.of(competitionEvent));

        service.postResults(expected.getId(),
                Arrays.asList(
                        new AthletePerformanceDTO(1, 3L,LocalTime.of(0,3,29,0)),
                        new AthletePerformanceDTO(2, 2L,LocalTime.of(0,3,29,5000000)),
                        new AthletePerformanceDTO(3, 1L,LocalTime.of(0,3,30,0))
                )
        );

        verify(competitionEventRepository).save(expected);
    }

}