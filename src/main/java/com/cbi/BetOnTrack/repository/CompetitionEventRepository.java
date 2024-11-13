package com.cbi.BetOnTrack.repository;

import com.cbi.BetOnTrack.model.CompetitionEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionEventRepository extends JpaRepository<CompetitionEvent, Long> {
}