package com.diplomski.backend.repository;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.enumeration.ActiveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,Long> {
    Optional<Airline> findByIataCode(String iataCode);
    Optional<Airline> findByIataCodeAndIcaoCode(String iataCode,String icao);

    Optional<Airline> findByIataCodeAndActiveStatus(String iataCode, ActiveStatus status);

    Optional<Airline> findByIataCodeAndIcaoCodeAndActiveStatus(String iataCode, String icaoCode, ActiveStatus active);

    boolean existsByIataCodeAndIcaoCode(String iataCode, String icaoCode);
}
