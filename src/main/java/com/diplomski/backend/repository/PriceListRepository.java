package com.diplomski.backend.repository;

import com.diplomski.backend.domain.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList,Long> {
}
