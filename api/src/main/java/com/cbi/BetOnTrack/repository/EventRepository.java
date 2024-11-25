package com.cbi.BetOnTrack.repository;

import com.cbi.BetOnTrack.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}