package com.diplomski.backend.repository;

import com.diplomski.backend.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    Optional<Flight> findByRouteFlight(Integer flight);
}
