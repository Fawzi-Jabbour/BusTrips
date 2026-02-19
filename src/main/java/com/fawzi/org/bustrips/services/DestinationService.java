package com.fawzi.org.bustrips.services;

import com.fawzi.org.bustrips.dtos.DestinationCreateRequest;
import com.fawzi.org.bustrips.dtos.DestinationDto;
import com.fawzi.org.bustrips.dtos.DestinationUpdateRequest;

import java.util.List;

public interface DestinationService {
    DestinationDto create(DestinationCreateRequest request);

    List<DestinationDto> findAll();

    DestinationDto findById(Integer id);

    void delete(Integer id);

    DestinationDto update(Integer id, DestinationUpdateRequest request);
}
