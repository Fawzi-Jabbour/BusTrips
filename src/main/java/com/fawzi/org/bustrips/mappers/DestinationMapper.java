package com.fawzi.org.bustrips.mappers;

import com.fawzi.org.bustrips.dtos.DestinationCreateRequest;
import com.fawzi.org.bustrips.dtos.DestinationDto;
import com.fawzi.org.bustrips.dtos.DestinationUpdateRequest;
import com.fawzi.org.bustrips.entities.Destination;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    DestinationDto toDto(Destination destination);
    Destination toEntity(DestinationCreateRequest request);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    void updateEntityFromDto(DestinationUpdateRequest request,
                             @MappingTarget Destination destination);

}
