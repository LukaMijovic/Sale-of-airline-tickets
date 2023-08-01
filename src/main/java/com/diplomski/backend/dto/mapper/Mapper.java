package com.diplomski.backend.dto.mapper;

import org.springframework.data.domain.Page;

import java.util.List;

public interface Mapper<E,DTO> {
    DTO entityToDTO(E entity);
    E DTOtoEntity(DTO dto);
    default List<DTO> entitiesToDTOs(List<E> entities){
        return entities.stream().map(this::entityToDTO).toList();
    }
    default List<E> DTOsToEntities(List<DTO> dtos){
        return dtos.stream().map(this::DTOtoEntity).toList();
    }
    default Page<DTO> entitiesToDTOs(Page<E> entities){
        return entities.map(this::entityToDTO);
    }
}
