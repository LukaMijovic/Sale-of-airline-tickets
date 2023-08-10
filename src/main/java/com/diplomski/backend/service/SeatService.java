package com.diplomski.backend.service;

import com.diplomski.backend.domain.Seat;

public interface SeatService {
    public Seat changeOpened(Seat seat,boolean opened);
}
