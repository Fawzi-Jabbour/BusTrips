package com.fawzi.org.bustrips.controllers;

import com.fawzi.org.bustrips.dtos.BusCreateRequest;
import com.fawzi.org.bustrips.dtos.BusDto;
import com.fawzi.org.bustrips.services.BusServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buses")
@RequiredArgsConstructor
public class BusController {
    private final BusServiceImpl busService;

    @PostMapping
    public ResponseEntity<BusDto> createBus(@Valid @RequestBody BusCreateRequest request){
        var busdto = busService.createBus(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(busdto);
    }
    @GetMapping
    public ResponseEntity<List<BusDto>> getall(){
        var buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }

}
