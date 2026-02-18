package com.fawzi.org.bustrips.services;

import com.fawzi.org.bustrips.dtos.SeatCreateRequest;
import com.fawzi.org.bustrips.dtos.SeatDto;

import java.util.List;

public interface SeatService {
    SeatDto create(SeatCreateRequest request);

    List<SeatDto> findAll();

    void delete(Integer id);
}

