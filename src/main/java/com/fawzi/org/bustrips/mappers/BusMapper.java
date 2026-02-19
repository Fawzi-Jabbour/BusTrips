package com.fawzi.org.bustrips.mappers;

import com.fawzi.org.bustrips.dtos.BusDto;
import com.fawzi.org.bustrips.dtos.BusCreateRequest;
import com.fawzi.org.bustrips.dtos.BusUpdateRequest;
import com.fawzi.org.bustrips.entities.Bus;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BusMapper {
    BusDto toDto(Bus bus);
    Bus toEntity(BusCreateRequest request);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    void updateEntityFromDto(BusUpdateRequest request,
                             @MappingTarget Bus bus);
}
