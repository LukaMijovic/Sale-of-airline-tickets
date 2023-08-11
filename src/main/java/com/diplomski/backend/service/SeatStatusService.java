package com.diplomski.backend.service;

import com.diplomski.backend.domain.SeatStatus;

public interface SeatStatusService {
    public SeatStatus reserveSeat(SeatStatus seatStatus);
    public SeatStatus cancelReservationSeat(SeatStatus seatStatus);
    public SeatStatus changeSeatStatus(SeatStatus seatStatus);
}
