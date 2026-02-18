package com.fawzi.org.bustrips.dtos;

import com.fawzi.org.bustrips.entities.BusStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BusDto {
    private Integer id;
    private Long plateNumber;
    private Integer busNumber;
    private String description;
    private Integer seatCapacity;
    private BusStatus status;
    private LocalDateTime createdAt;
}
