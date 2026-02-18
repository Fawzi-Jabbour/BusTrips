package com.fawzi.org.bustrips.controllers;

import com.fawzi.org.bustrips.dtos.SeatCreateRequest;
import com.fawzi.org.bustrips.dtos.SeatDto;
import com.fawzi.org.bustrips.services.SeatServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatServiceImpl seatService;

    @PostMapping
    public ResponseEntity<SeatDto> createseat(@Valid @RequestBody SeatCreateRequest request){
        SeatDto dto = seatService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
    @GetMapping
    public ResponseEntity<List<SeatDto>> getallseats(){
        List<SeatDto> seats = seatService.findAll();
        return ResponseEntity.ok(seats);
    }

}
