package com.fawzi.org.bustrips.mappers;

import com.fawzi.org.bustrips.dtos.SeatCreateRequest;
import com.fawzi.org.bustrips.dtos.SeatDto;
import com.fawzi.org.bustrips.entities.Seat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatDto toDto(Seat seat);
    Seat toEntity(SeatCreateRequest request);
}
