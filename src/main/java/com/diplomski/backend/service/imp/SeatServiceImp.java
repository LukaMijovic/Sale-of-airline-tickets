package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Seat;
import com.diplomski.backend.repository.SeatRepository;
import com.diplomski.backend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImp implements SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Override
    public Seat changeOpened(Seat seat,boolean opened) {
        seat.setOpened(opened);
        return seatRepository.save(seat);
    }
}
