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
    private static Event event100m;

    @BeforeAll
    public static void setupEvent(){
        EventGroup raceEvent = new EventGroup("Races");
        EventGroup throwingEvent = new EventGroup("Throw");

        event1500m = new Event(raceEvent, "1500");
        eventDiscusThrow = new Event(throwingEvent, "Discus Throw");
        event100m = new Event(raceEvent, "100m");
    }

    @Test
    public void emptyGetResult(){
        List<Athlete> startList = new ArrayList<>();
        CompetitionEvent competitionEvent = new CompetitionEvent(event1500m,"Final" ,startList);
        List<AthleteResult> expected = new ArrayList<>();
        assertEquals(expected, competitionEvent.getResult());
    }

    @Test
    public void oneDistancePerfGetResult(){
        Athlete jakob = new Athlete("Jakob", "Ingerbritsen");
        List<Athlete> startList = List.of(jakob);
        CompetitionEvent competitionEvent = new CompetitionEvent(event1500m,"Final",startList);

        List<AthletePerformance> athletePerformances = List.of(
                new AthletePerformance(
                        jakob,
                        new RunPerformance(1, LocalTime.of(0, 3, 29, 0))
                )
        );
        competitionEvent.setResults(athletePerformances);

        List<AthleteResult> expected = List.of(
                new AthleteResult(1, "Jakob", "Ingerbritsen", "03:29.00")
        );
        assertEquals(expected,competitionEvent.getResult());
    }

    @Test
    public void raceDistancePerfGetResult(){
        Athlete cole = new Athlete("Cole","Hocker");
        Athlete yared = new Athlete("Yared","Nuguse");
        Athlete josh = new Athlete("Josh","Kerr");
        List<Athlete> startList = Arrays.asList(cole,yared,josh);
        CompetitionEvent competitionEvent = new CompetitionEvent(event1500m,"Final", startList);

        List<AthletePerformance> athletePerformances = Arrays.asList(
                new AthletePerformance(
                        cole,
                        new RunPerformance(1, LocalTime.of(0,3,27,650000000))
                ),
                new AthletePerformance(
                        yared,
                        new RunPerformance(3, LocalTime.of(0,3,27,800000000))
                ),
                new AthletePerformance(
                        josh ,
                        new RunPerformance(2, LocalTime.of(0,3,27,790000000))
                )
        );
        competitionEvent.setResults(athletePerformances);

        List<AthleteResult> expected = Arrays.asList(
                new AthleteResult(1,"Cole","Hocker","03:27.65"),
                new AthleteResult(2,"Josh","Kerr","03:27.79"),
                new AthleteResult(3,"Yared","Nuguse","03:27.80")
        );
        assertEquals(expected,competitionEvent.getResult());
    }

    @Test
    public void babyThrowEventGetResult(){
        Athlete melina = new Athlete("Melina","Robert-Michon");
        List<Athlete> startList = List.of(melina);
        CompetitionEvent competitionEvent = new CompetitionEvent(eventDiscusThrow,"Final",startList);

        List<AthletePerformance> athletePerformance = List.of(
                new AthletePerformance(
                        melina,
                        new ThrowPerformance(1,66.73,-1.0)
                )
        );
        competitionEvent.setResults(athletePerformance);

        List<AthleteResult> expected = List.of(
                new AthleteResult(1, "Melina","Robert-Michon","66.73 (-1.0m/s)")
        );

        assertEquals(expected,competitionEvent.getResult());
    }

    @Test
    public void completeThrowEventGetResult(){
        Athlete melina = new Athlete("Melina","Robert-Michon");
        Athlete valarie = new Athlete("Valarie","Allman");
        Athlete jorinde = new Athlete("Jorinde","Van Klinken");
        List<Athlete> startList = Arrays.asList(melina,valarie,jorinde);
        CompetitionEvent competitionEvent = new CompetitionEvent(eventDiscusThrow,"Final",startList);

        List<AthletePerformance> athletePerformances = Arrays.asList(
                new AthletePerformance(
                        melina,
                        new ThrowPerformance(2,66.73,-1.0)
                ),
                new AthletePerformance(
                        valarie,
                        new ThrowPerformance(1,69.59,-1.0)
                ),
                new AthletePerformance(
                        jorinde,
                        new ThrowPerformance(3,64.81,-1.0)
                )
        );
        competitionEvent.setResults(athletePerformances);

        List<AthleteResult> expected = Arrays.asList(
                new AthleteResult(1, "Valarie","Allman","69.59 (-1.0m/s)"),
                new AthleteResult(2, "Melina","Robert-Michon","66.73 (-1.0m/s)"),
                new AthleteResult(3, "Jorinde","Van Klinken","64.81 (-1.0m/s)")
        );

        assertEquals(expected,competitionEvent.getResult());
    }

    @Test
    public void sprintEventGetResult(){
        Athlete kishane = new Athlete("Kishane","Thompson");
        Athlete noah = new Athlete("Noah","Lyles");
        Athlete fred = new Athlete("Fred","Kerley");
        List<Athlete> startList = Arrays.asList(kishane,noah,fred);
        CompetitionEvent competitionEvent = new CompetitionEvent(event100m,"Final",startList);

        List<AthletePerformance> athletePerformances = Arrays.asList(
                new AthletePerformance(
                        kishane,
                        new RunPerformance(2,LocalTime.of(0,0,9,797890000),1.0)
                ),
                new AthletePerformance(
                        noah,
                        new RunPerformance(1,LocalTime.of(0,0,9,797840000),1.0)
                ),
                new AthletePerformance(
                        fred,
                        new RunPerformance(3,LocalTime.of(0,0,9,810000000),1.0)
                )
        );
        competitionEvent.setResults(athletePerformances);

        List<AthleteResult> expected = Arrays.asList(
                new AthleteResult(1, "Noah","Lyles","09.79 (1.0m/s)"),
                new AthleteResult(2, "Kishane","Thompson","09.79 (1.0m/s)"),
                new AthleteResult(3, "Fred","Kerley","09.81 (1.0m/s)")
        );

        assertEquals(expected,competitionEvent.getResult());
    }


}