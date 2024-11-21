package com.cbi.BetOnTrack.repository;

import com.cbi.BetOnTrack.model.Profile.Bookmaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmakerRepository extends JpaRepository<Bookmaker, Long> {
}