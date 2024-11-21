package com.cbi.BetOnTrack.repository;

import com.cbi.BetOnTrack.model.Profile.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}