package com.fawzi.org.bustrips.services;

import com.fawzi.org.bustrips.dtos.BusCreateRequest;
import com.fawzi.org.bustrips.dtos.BusDto;

import java.util.List;

public interface BusService {
    BusDto createBus(BusCreateRequest request);

    BusDto getBusById(int id);

    List<BusDto> getAllBuses();
}
