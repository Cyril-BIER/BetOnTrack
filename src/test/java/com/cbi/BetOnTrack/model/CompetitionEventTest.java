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
    private static Event event1500m;
    private static Event eventDiscusThrow;

    @BeforeAll
    public static void setupEvent(){
        EventGroup distanceRunning = new EventGroup("Distance Running");
        EventGroup throwingEvent = new EventGroup("Throw");

        event1500m = new Event(distanceRunning, "1500");
        eventDiscusThrow = new Event(throwingEvent, "Discus Throw");

    }

    @Test
    public void emptyGetResult(){
        CompetitionEvent competitionEvent = new CompetitionEvent(event1500m);
        List<AthleteResult> expected = new ArrayList<>();
        assertEquals(expected, competitionEvent.getResult());
    }

    @Test
    public void oneDistancePerfGetResult(){
        List<AthletePerformance> athletePerformances = List.of(
                new AthletePerformance(
                        new Athlete("Jakob", "Ingerbritsen"),
                        new RunPerformance(1, LocalTime.of(0, 3, 29, 0))
                )
        );
        CompetitionEvent competitionEvent = new CompetitionEvent(event1500m,athletePerformances);

        List<AthleteResult> expected = List.of(
                new AthleteResult(1, "Jakob", "Ingerbritsen", "03:29.00")
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
        CompetitionEvent competitionEvent = new CompetitionEvent(event1500m,athletePerformances);

        List<AthleteResult> expected = Arrays.asList(
                new AthleteResult(1,"Cole","Hocker","03:27.65"),
                new AthleteResult(2,"Josh","Kerr","03:27.79"),
                new AthleteResult(3,"Yared","Nuguse","03:27.80")
        );
        assertEquals(expected,competitionEvent.getResult());
    }

    @Test
    public void babyThrowEventGetResult(){
        List<AthletePerformance> athletePerformance = List.of(
                new AthletePerformance(
                        new Athlete("Melina","Robert-Michon"),
                        new ThrowPerformance(1,66.73,-1.0)
                )
        );
        CompetitionEvent competitionEvent = new CompetitionEvent(eventDiscusThrow,athletePerformance);

        List<AthleteResult> expected = List.of(
                new AthleteResult(1, "Melina","Robert-Michon","66.73 (-1.0m/s)")
        );

        assertEquals(expected,competitionEvent.getResult());
    }

    @Test
    public void completeThrowEventGetResult(){
        List<AthletePerformance> athletePerformances = Arrays.asList(
                new AthletePerformance(
                        new Athlete("Melina","Robert-Michon"),
                        new ThrowPerformance(2,66.73,-1.0)
                ),
                new AthletePerformance(
                        new Athlete("Valarie","Allman"),
                        new ThrowPerformance(1,69.59,-1.0)
                ),
                new AthletePerformance(
                        new Athlete("Jorinde","Van Klinken"),
                        new ThrowPerformance(3,64.81,-1.0)
                )

        );
        CompetitionEvent competitionEvent = new CompetitionEvent(eventDiscusThrow,athletePerformances);

        List<AthleteResult> expected = Arrays.asList(
                new AthleteResult(1, "Valarie","Allman","69.59 (-1.0m/s)"),
                new AthleteResult(2, "Melina","Robert-Michon","66.73 (-1.0m/s)"),
                new AthleteResult(3, "Jorinde","Van Klinken","64.81 (-1.0m/s)")
        );

        assertEquals(expected,competitionEvent.getResult());
    }


}