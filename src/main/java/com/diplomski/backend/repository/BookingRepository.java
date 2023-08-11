package com.diplomski.backend.repository;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.domain.enumeration.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findAllByStatusAndCustomerId(ReservationStatus requested, Long id);

    List<Booking> findAllByStatus(ReservationStatus requested);

    List<Booking> findByStatusAndCustomerId(String requested, Long id);
}
