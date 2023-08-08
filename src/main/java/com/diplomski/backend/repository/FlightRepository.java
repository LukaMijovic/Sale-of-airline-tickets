package com.diplomski.backend.repository;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.enumeration.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    Optional<Flight> findByRouteFlight(Integer flight);

    Page<Flight> findByFlightStatus(FlightStatus active, Pageable pageable);
}
