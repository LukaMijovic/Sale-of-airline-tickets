package com.diplomski.backend.dto.request;

public record RouteRequest(
        Long depAirportId,
        Long arrAirportId,
        String depTerminal,
        String arrTerminal,
        String depTime,
        String arrTime,
        Long airlineId
) {
}
