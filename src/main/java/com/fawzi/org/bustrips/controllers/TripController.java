package com.fawzi.org.bustrips.controllers;

import com.fawzi.org.bustrips.dtos.TripCreateRequest;
import com.fawzi.org.bustrips.dtos.TripDto;
import com.fawzi.org.bustrips.services.TripServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripServiceImpl tripService;



    @PostMapping
    public  ResponseEntity<TripDto> create(@Valid @RequestBody TripCreateRequest request){
        var dto =tripService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
    @GetMapping
    public ResponseEntity<List<TripDto>> getAll(){
        return ResponseEntity.ok(tripService.getAll());
    }
    @GetMapping({"/{id}"})
    public ResponseEntity<TripDto> getByid(@PathVariable Integer id){
        var tripdto = tripService.findById(id);
        if(tripdto==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tripdto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        tripService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
