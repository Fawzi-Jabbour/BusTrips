package com.fawzi.org.bustrips.services;

import com.fawzi.org.bustrips.dtos.SeatCreateRequest;
import com.fawzi.org.bustrips.dtos.SeatDto;
import com.fawzi.org.bustrips.entities.Bus;
import com.fawzi.org.bustrips.entities.Seat;
import com.fawzi.org.bustrips.exceptions.BusNotFoundException;
import com.fawzi.org.bustrips.exceptions.DuplicateSeatException;
import com.fawzi.org.bustrips.mappers.SeatMapper;
import com.fawzi.org.bustrips.repositories.BusRepository;
import com.fawzi.org.bustrips.repositories.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService{
    private final SeatRepository seatRepository;
    private final BusRepository busRepository;
    private final SeatMapper seatMapper;

    @Override
    public SeatDto create(SeatCreateRequest request) {
        if(seatRepository.existsByBusIdAndSeatNumber(request.getBusId(),request.getSeatNumber())){
            throw new DuplicateSeatException("Seat already exists for this bus");
        }
        Bus bus = busRepository.findById(request.getBusId())
                .orElseThrow(() -> new BusNotFoundException("Bus not found"));
        Seat seat = new Seat();
        seat.setSeatNumber(request.getSeatNumber());
        seat.setBus(bus);
        Seat saved = seatRepository.save(seat);
        return seatMapper.toDto(saved);

    }

    @Override
    public List<SeatDto> findAll() {
       return seatRepository.findAll()
               .stream()
               .map(seatMapper::toDto)
               .toList();
    }

    @Override
    public void delete(Integer id) {
        var seat = seatRepository.findById(id).orElse(null);
        seatRepository.deleteById(id);
    }
}
