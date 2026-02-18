package com.fawzi.org.bustrips.services;

import com.fawzi.org.bustrips.dtos.DestinationCreateRequest;
import com.fawzi.org.bustrips.dtos.DestinationDto;
import com.fawzi.org.bustrips.entities.Destination;
import com.fawzi.org.bustrips.exceptions.DestinatonNotFoundException;
import com.fawzi.org.bustrips.exceptions.DuplicateDestinationCodeException;
import com.fawzi.org.bustrips.exceptions.SeatNotFoundException;
import com.fawzi.org.bustrips.mappers.DestinationMapper;
import com.fawzi.org.bustrips.repositories.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;
    private final DestinationMapper destinationMapper;

    @Override
    public DestinationDto create(DestinationCreateRequest request) {


        if (destinationRepository.existsByCode(request.getCode().toUpperCase())) {
            throw new DuplicateDestinationCodeException("Destination code already exists");
        }
        Destination destination = destinationMapper.toEntity(request);

        Destination saved = destinationRepository.save(destination);

        return destinationMapper.toDto(saved);
    }


    @Override
    public List<DestinationDto> findAll() {
        return destinationRepository.findAll()
                .stream()
                .map(destinationMapper::toDto)
                .toList();
    }

    @Override
    public DestinationDto findById(Integer id) {
        var destination = destinationRepository.findById(id).orElse(null);
        return destinationMapper.toDto(destination);
    }

    @Override
    public void delete(Integer id) {
        var destination = destinationRepository.findById(id)
                .orElseThrow(() -> new DestinatonNotFoundException("Destinaton not found "));

        destinationRepository.delete(destination);

    }


}
