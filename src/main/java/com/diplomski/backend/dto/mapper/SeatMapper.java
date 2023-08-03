package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Seat;
import com.diplomski.backend.dto.SeatDTO;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper implements Mapper<Seat, SeatDTO> {
    @Override
    public SeatDTO entityToDTO(Seat entity) {
        return new SeatDTO(
                entity.getId(),
                entity.getCode(),
                entity.getCabin(),
                entity.getSeatType(),
                entity.getSeatClass(),
                entity.getOpened()
        );
    }

    @Override
    public Seat DTOtoEntity(SeatDTO seatDTO) {
        return null;
    }
}
