package com.diplomski.backend.dto;

public record PriceListDTO(
        Long id,
        double economy,
        double economyPlus,
        double preferredEconomy,
        double business,
        double firstClass
) {
}
