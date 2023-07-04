package com.diplomski.backend.repository;

import com.diplomski.backend.external.Pagination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationRepository extends JpaRepository<Pagination,Long> {
}
