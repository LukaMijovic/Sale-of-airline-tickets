package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.SeatStatus;
import com.diplomski.backend.domain.enumeration.SeatStatusEnum;
import com.diplomski.backend.repository.SeatStatusRepository;
import com.diplomski.backend.service.SeatService;
import com.diplomski.backend.service.SeatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatStatusServiceImp implements SeatStatusService {
    @Autowired
    private SeatStatusRepository seatStatusRepository;
    @Autowired
    private SeatService seatService;
    @Override
    public SeatStatus reserveSeat(SeatStatus seatStatus) {
        seatService.changeOpened(seatStatus.getSeat(),false);
        seatStatus.setSeatStatus(SeatStatusEnum.RESERVED);
        return seatStatusRepository.save(seatStatus);
    }
}
