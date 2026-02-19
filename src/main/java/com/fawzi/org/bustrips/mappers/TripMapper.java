package com.fawzi.org.bustrips.mappers;

import com.fawzi.org.bustrips.dtos.TripCreateRequest;
import com.fawzi.org.bustrips.dtos.TripDto;
import com.fawzi.org.bustrips.entities.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TripMapper {

    @Mapping(target = "busId" ,source = "bus.id")
    @Mapping(target = "originId",source = "origin.id")
    @Mapping(target = "originName", source = "origin.name")
    @Mapping(target = "destinationId",source = "destination.id")
    @Mapping(target = "destinationName", source = "destination.name")
    TripDto toDto(Trip trip);

    Trip toEntity(TripCreateRequest request);
}
