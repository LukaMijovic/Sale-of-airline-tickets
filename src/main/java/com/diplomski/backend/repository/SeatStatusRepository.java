package com.diplomski.backend.repository;

import com.diplomski.backend.domain.SeatStatus;
import com.diplomski.backend.domain.enumeration.SeatStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatStatusRepository extends JpaRepository<SeatStatus,Long> {
    Optional<SeatStatus> findBySeatStatusAndFlightIdAndSeatId(SeatStatusEnum opened, Long flightId, Long seatId);
}
