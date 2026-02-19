package com.fawzi.org.bustrips.controllers;

import com.fawzi.org.bustrips.dtos.DestinationCreateRequest;
import com.fawzi.org.bustrips.dtos.DestinationDto;
import com.fawzi.org.bustrips.dtos.DestinationUpdateRequest;
import com.fawzi.org.bustrips.services.DestinationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations")
@RequiredArgsConstructor
public class DestinationController {
    private final DestinationServiceImpl destinationService;

    @PostMapping
    public ResponseEntity<DestinationDto> create(@Valid @RequestBody DestinationCreateRequest request){
        DestinationDto dto = destinationService.create(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<DestinationDto>> getAll() {

        List<DestinationDto> destinations = destinationService.findAll();

        return ResponseEntity.ok(destinations);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DestinationDto> getById(@PathVariable Integer id) {

        DestinationDto dto = destinationService.findById(id);
        if (dto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        destinationService.delete(id);

        return ResponseEntity.noContent().build();
    }
    @PatchMapping ("/{id}")
    public DestinationDto update(
            @PathVariable Integer id,
            @Valid @RequestBody DestinationUpdateRequest request) {

        return destinationService.update(id, request);
    }

}
