package com.cbi.BetOnTrack.model;

import com.cbi.BetOnTrack.dto.AthleteResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionEventTest {
    private static Event event;

    @BeforeAll
    public static void setupEvent(){
        EventGroup eventGroup = new EventGroup("Distance Running");
        event = new Event(eventGroup, "1500");
    }

    @Test
    public void emptyGetResult(){
        CompetitionEvent competitionEvent = new CompetitionEvent(event);
        List<AthleteResult> expected = new ArrayList<>();
        assertEquals(expected, competitionEvent.getResult());
    }

    @Test
    public void oneDistancePerfGetResult(){
        List<AthletePerformance> athletePerformances = Arrays.asList(
                new AthletePerformance(
                        new Athlete("Jakob","Ingerbritsen"),
                        new RunPerformance(1, LocalTime.of(0,3,29,0))
                )
        );
        CompetitionEvent competitionEvent = new CompetitionEvent(event,athletePerformances);

        List<AthleteResult> expected = Arrays.asList(
                new AthleteResult(1,"Jakob","Ingerbritsen","03:29.00")
        );
        assertEquals(expected,competitionEvent.getResult());
    }

    @Test
    public void raceDistancePerfGetResult(){
        List<AthletePerformance> athletePerformances = Arrays.asList(
                new AthletePerformance(
                        new Athlete("Cole","Hocker"),
                        new RunPerformance(1, LocalTime.of(0,3,27,650000000))
                ),
                new AthletePerformance(
                        new Athlete("Yared","Nuguse"),
                        new RunPerformance(3, LocalTime.of(0,3,27,800000000))
                ),
                new AthletePerformance(
                        new Athlete("Josh","Kerr"),
                        new RunPerformance(2, LocalTime.of(0,3,27,790000000))
                )
        );
        CompetitionEvent competitionEvent = new CompetitionEvent(event,athletePerformances);

        List<AthleteResult> expected = Arrays.asList(
                new AthleteResult(1,"Cole","Hocker","03:27.65"),
                new AthleteResult(2,"Josh","Kerr","03:27.79"),
                new AthleteResult(3,"Yared","Nuguse","03:27.80")
        );
        assertEquals(expected,competitionEvent.getResult());
    }
}