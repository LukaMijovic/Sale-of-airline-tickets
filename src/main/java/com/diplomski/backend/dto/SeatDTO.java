package com.diplomski.backend.dto;

import com.diplomski.backend.domain.enumeration.SeatClass;
import com.diplomski.backend.domain.enumeration.SeatType;

public record SeatDTO(
        Long id,
        String code,
        String cabin,
        SeatType seatType,
        SeatClass seatClass,
        Boolean opened
) {
}
