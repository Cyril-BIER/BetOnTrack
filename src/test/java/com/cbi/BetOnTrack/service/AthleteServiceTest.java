package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.model.Athlete;
import com.cbi.BetOnTrack.repository.AthleteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AthleteServiceTest {
    @Mock
    AthleteRepository athleteRepository;

    @InjectMocks
    AthleteService service;

    @Test
    public void babyGetAthletes(){
        List<Athlete> expected = Arrays.asList(
                new Athlete(1L,"Jakob","Ingerbritsen"),
                new Athlete(2L,"Noah","Lyles"),
                new Athlete(3L,"Mondo","Duplantis")
        );
        when(athleteRepository.findAllById(new ArrayList<>())).thenReturn(expected);
        assertEquals(expected, service.getAthletes(new ArrayList<>()));
    }

    @Test
    public void getOneAthletes(){
        List<Athlete> expected = List.of(
                new Athlete(2L, "Noah", "Lyles")
        );

        when(athleteRepository.findAllById(List.of(2L))).thenReturn(expected);
        assertEquals(expected, service.getAthletes(List.of(2L)));
    }

    @Test
    public void getTwoAthletes(){
        List<Athlete> expected = List.of(
                new Athlete(2L, "Noah", "Lyles"),
                new Athlete(3L,"Mondo","Duplantis")
        );

        when(athleteRepository.findAllById(List.of(2L,3L))).thenReturn(expected);
        assertEquals(expected, service.getAthletes(List.of(2L,3L)));
    }


}