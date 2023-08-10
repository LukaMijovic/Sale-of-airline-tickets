package com.diplomski.backend.repository;

import com.diplomski.backend.domain.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatStatusRepository extends JpaRepository<SeatStatus,Long> {
}
