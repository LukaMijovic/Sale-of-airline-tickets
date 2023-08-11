package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.SeatStatus;
import com.diplomski.backend.domain.enumeration.SeatStatusEnum;
import com.diplomski.backend.repository.SeatStatusRepository;
import com.diplomski.backend.service.SeatService;
import com.diplomski.backend.service.SeatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SeatStatusServiceImp implements SeatStatusService {
    @Autowired
    private SeatStatusRepository seatStatusRepository;
    @Autowired
    private SeatService seatService;
    @Override
    public SeatStatus reserveSeat(SeatStatus seatStatus) {
        Optional<SeatStatus> optionalSeatStatus=seatStatusRepository.findBySeatStatusAndFlightIdAndSeatId(SeatStatusEnum.OPENED,
                seatStatus.getFlight().getId(),seatStatus.getSeat().getId());
        if(optionalSeatStatus.isPresent()){
            SeatStatus seatStatusEx=optionalSeatStatus.get();
            System.out.println(seatStatusEx.getId());
            seatService.changeOpened(seatStatusEx.getSeat(),false);
            seatStatusEx.setSeatStatus(SeatStatusEnum.RESERVED);
            seatStatusEx.setUpdated(LocalDateTime.now());
            return seatStatusRepository.save(seatStatusEx);
        }
        seatService.changeOpened(seatStatus.getSeat(),false);
        seatStatus.setSeatStatus(SeatStatusEnum.RESERVED);
        seatStatus.setUpdated(LocalDateTime.now());
        return seatStatusRepository.save(seatStatus);
    }

    @Override
    public SeatStatus cancelReservationSeat(SeatStatus seatStatus) {
        seatService.changeOpened(seatStatus.getSeat(),true);
        seatStatus.setSeatStatus(SeatStatusEnum.OPENED);
        seatStatus.setUpdated(LocalDateTime.now());
        return seatStatusRepository.save(seatStatus);
    }

    @Override
    public SeatStatus changeSeatStatus(SeatStatus seatStatus) {
        return null;
    }
}
