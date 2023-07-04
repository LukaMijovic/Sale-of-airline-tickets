package com.diplomski.backend.repository;

import com.diplomski.backend.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    Optional<City> findByIataCode(String iataCode);
}
