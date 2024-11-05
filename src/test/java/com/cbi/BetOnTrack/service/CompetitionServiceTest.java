package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.dto.CreateCompetition;
import com.cbi.BetOnTrack.model.Competition;
import com.cbi.BetOnTrack.repository.CompetitionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CompetitionServiceTest {
    @Mock
    CompetitionRepository competitionRepository;

    @InjectMocks
    CompetitionService service;

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
}