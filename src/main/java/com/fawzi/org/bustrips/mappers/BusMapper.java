package com.fawzi.org.bustrips.mappers;

import com.fawzi.org.bustrips.dtos.BusDto;
import com.fawzi.org.bustrips.dtos.BusCreateRequest;
import com.fawzi.org.bustrips.entities.Bus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusMapper {
    BusDto toDto(Bus bus);
    Bus toEntity(BusCreateRequest request);
}
