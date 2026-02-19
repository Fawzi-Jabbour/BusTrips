package com.fawzi.org.bustrips.services;

import com.fawzi.org.bustrips.dtos.TripCreateRequest;
import com.fawzi.org.bustrips.dtos.TripDto;

import java.util.List;

public interface TripService {
    TripDto create(TripCreateRequest request);
    List<TripDto> getAll();
    void delete(Integer id);
    TripDto findById(Integer id);
}
