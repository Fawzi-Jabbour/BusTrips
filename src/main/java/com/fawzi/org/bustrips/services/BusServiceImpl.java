package com.fawzi.org.bustrips.services;

import com.fawzi.org.bustrips.dtos.BusCreateRequest;
import com.fawzi.org.bustrips.dtos.BusDto;
import com.fawzi.org.bustrips.dtos.BusUpdateRequest;
import com.fawzi.org.bustrips.entities.Bus;
import com.fawzi.org.bustrips.exceptions.BusNotFoundException;
import com.fawzi.org.bustrips.exceptions.BusNumberDuplicationException;
import com.fawzi.org.bustrips.exceptions.PlateNumberDuplicationException;
import com.fawzi.org.bustrips.mappers.BusMapper;
import com.fawzi.org.bustrips.repositories.BusRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BusServiceImpl implements  BusService{
    private final BusRepository busRepository;
    private  final BusMapper busMapper;

    @Override
    public BusDto createBus(BusCreateRequest request) {
        if (busRepository.existsByPlateNumber(request.getPlateNumber())) {
            throw new PlateNumberDuplicationException("Plate number already exists");
        }

        if (busRepository.existsByBusNumber(request.getBusNumber())) {
            throw new BusNumberDuplicationException("Bus number already exists");
        }

        Bus bus = busMapper.toEntity(request);
        var savedbus= busRepository.save(bus);

        return busMapper.toDto(savedbus);
    }

    @Override
    public BusDto getBusById(int id) {
        Bus bus = busRepository.findById(id).orElse(null);
        return busMapper.toDto(bus);
    }

    @Override
    public List<BusDto> getAllBuses() {
        return busRepository.findAll()
                .stream()
                .map(busMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public BusDto update(Integer id, BusUpdateRequest request) {
        Bus bus = busRepository.findById(id).orElseThrow(
                () ->new BusNotFoundException("BUS NOT FOUND"));
        if (!bus.getBusNumber().equals(request.getBusNumber())
                && busRepository.existsByBusNumberAndIdNot(request.getBusNumber(), id)) {
            throw new BusNumberDuplicationException("Bus Number already exists");
        }
        busMapper.updateEntityFromDto(request,bus);
        return busMapper.toDto(bus);

    }

}
