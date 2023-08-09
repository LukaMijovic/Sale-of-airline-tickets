package com.diplomski.backend.dto.request;

import java.time.LocalDate;

public record FlightRequest(
        String cityDep,
        String cityArr,
        String timeTravel
) {
}
