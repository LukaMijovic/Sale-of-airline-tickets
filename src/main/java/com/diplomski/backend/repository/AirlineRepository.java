package com.diplomski.backend.repository;

import com.diplomski.backend.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,Long> {
    Optional<Airline> findByIataCode(String iataCode);
}
