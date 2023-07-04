package com.diplomski.backend.repository;

import com.diplomski.backend.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
