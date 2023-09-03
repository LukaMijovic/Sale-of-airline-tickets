package com.diplomski.backend.repository;

import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long>{
    Optional<Airport> findByIataCode(String iataCode);

    boolean existsByName(String name);

    boolean existsByCityName(String name);

    List<Airport> findByCity(City city);

    Page<Airport> findByCityNameContaining(Pageable pageable,String city);

    Page<Airport> findByCityNameIgnoreCaseStartingWith(Pageable pageable, String city);
}
