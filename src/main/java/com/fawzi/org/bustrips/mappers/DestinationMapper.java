package com.fawzi.org.bustrips.mappers;

import com.fawzi.org.bustrips.dtos.DestinationCreateRequest;
import com.fawzi.org.bustrips.dtos.DestinationDto;
import com.fawzi.org.bustrips.dtos.DestinationUpdateRequest;
import com.fawzi.org.bustrips.entities.Destination;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    DestinationDto toDto(Destination destination);
    Destination toEntity(DestinationCreateRequest request);

    void updateEntityFromDto(DestinationUpdateRequest request,
                             @MappingTarget Destination destination);

}
