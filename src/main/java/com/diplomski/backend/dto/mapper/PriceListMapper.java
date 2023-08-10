package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.PriceList;
import com.diplomski.backend.dto.PriceListDTO;
import org.springframework.stereotype.Component;

@Component
public class PriceListMapper implements Mapper<PriceList, PriceListDTO> {
    @Override
    public PriceListDTO entityToDTO(PriceList entity) {
        return new PriceListDTO(
                entity.getId(),
                entity.getEconomyClassPrice().doubleValue(),
                entity.getEconomyPlusClassPrice().doubleValue(),
                entity.getPreferredEconomyClassPrice().doubleValue(),
                entity.getBusinessClassPrice().doubleValue(),
                entity.getFirstClassPrice().doubleValue()
        );
    }

    @Override
    public PriceList DTOtoEntity(PriceListDTO priceListDTO) {
        return null;
    }
}
