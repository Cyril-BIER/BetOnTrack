package com.cbi.BetOnTrack.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AthletePerformanceDTOTest {
    @Test
    public void constructorWithTimeAndNoWind(){
        AthletePerformanceDTO dto = new AthletePerformanceDTO(1,1L, LocalTime.of(0,3,30,0));

        assertEquals(1, dto.getRank());
        assertEquals(1L,dto.getAthleteID());
        assertEquals(LocalTime.of(0,3,30,0),dto.getTimePerformance());
        assertNull(dto.getDistancePerformance());
    }

    @Test
    public void constructorWithDistance(){
        AthletePerformanceDTO dto = new AthletePerformanceDTO(1,1L, 30.0);
        assertEquals(1, dto.getRank());
        assertEquals(1L,dto.getAthleteID());
        assertEquals(30.0,dto.getDistancePerformance());
        assertNull(dto.getTimePerformance());
    }

}