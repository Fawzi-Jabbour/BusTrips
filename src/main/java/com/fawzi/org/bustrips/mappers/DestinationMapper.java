package com.fawzi.org.bustrips.mappers;

import com.fawzi.org.bustrips.dtos.DestinationCreateRequest;
import com.fawzi.org.bustrips.dtos.DestinationDto;
import com.fawzi.org.bustrips.entities.Destination;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    DestinationDto toDto(Destination destination);
    Destination toEntity(DestinationCreateRequest request);

}
