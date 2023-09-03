package com.diplomski.backend.dto.request;

public record RouteRequest(
        Long departureId,
        Long arrivalId,
        String departureTerminal,
        String arrivalTerminal,
        String departureTime,
        String arrivalTime,
        Long airlineId
) {
}
