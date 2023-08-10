package com.diplomski.backend.dto;

import java.math.BigDecimal;

public record TicketDTO(
        Long id,
        String code,
        BigDecimal amount
) {
}
