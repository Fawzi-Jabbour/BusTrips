package com.fawzi.org.bustrips.mappers;

import com.fawzi.org.bustrips.dtos.SeatCreateRequest;
import com.fawzi.org.bustrips.dtos.SeatDto;
import com.fawzi.org.bustrips.entities.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeatMapper {

    @Mapping(source = "bus.id", target = "busId")
    SeatDto toDto(Seat seat);
    Seat toEntity(SeatCreateRequest request);
}
