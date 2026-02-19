package com.fawzi.org.bustrips.services;

import com.fawzi.org.bustrips.dtos.TripCreateRequest;
import com.fawzi.org.bustrips.dtos.TripDto;
import com.fawzi.org.bustrips.entities.Trip;
import com.fawzi.org.bustrips.entities.TripStatus;
import com.fawzi.org.bustrips.exceptions.BusNotFoundException;
import com.fawzi.org.bustrips.exceptions.DestinatonNotFoundException;
import com.fawzi.org.bustrips.exceptions.TripNotFoundException;
import com.fawzi.org.bustrips.mappers.TripMapper;
import com.fawzi.org.bustrips.repositories.BusRepository;
import com.fawzi.org.bustrips.repositories.DestinationRepository;
import com.fawzi.org.bustrips.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService{
    private final TripRepository tripRepository;
    private final BusRepository busRepository;
    private final DestinationRepository destinationRepository;
    private final TripMapper tripMapper;
    @Override
    public TripDto create(TripCreateRequest request) {
        var bus = busRepository.findById(request.getBusId()).orElseThrow(
                () -> new BusNotFoundException("Bus Not Found")
        );
        var destination = destinationRepository.findById(request.getDestinationId()).orElseThrow(
                () -> new DestinatonNotFoundException("Destination Not Found")
        );
        var origin = destinationRepository.findById(request.getOriginId()).orElseThrow(
                () -> new DestinatonNotFoundException("Origin Not Found")
        );
        Trip trip = tripMapper.toEntity(request);
        trip.setBus(bus);
        trip.setOrigin(origin);
        trip.setDestination(destination);
        trip.setStatus(TripStatus.valueOf(request.getStatus()));
        Trip saved = tripRepository.save(trip);
        return tripMapper.toDto(saved);
    }

    @Override
    public List<TripDto> getAll() {
        return tripRepository.findAll()
                .stream()
                .map(tripMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Integer id) {
        var trip = tripRepository.findById(id).orElseThrow(()->new TripNotFoundException("Trip Not Found"));
        tripRepository.delete(trip);

    }

    @Override
    public TripDto findById(Integer id) {
       var trip=  tripRepository.findById(id).orElse(null);
       return  tripMapper.toDto(trip);
    }
}
