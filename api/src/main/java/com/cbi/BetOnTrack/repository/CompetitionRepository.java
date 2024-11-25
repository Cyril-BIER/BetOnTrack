package com.cbi.BetOnTrack.repository;

import com.cbi.BetOnTrack.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}