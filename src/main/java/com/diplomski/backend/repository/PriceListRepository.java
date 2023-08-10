package com.diplomski.backend.repository;

import com.diplomski.backend.domain.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList,Long> {
    Optional<PriceList> findByRouteId(Long id);
}
