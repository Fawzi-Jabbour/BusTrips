package com.fawzi.org.bustrips.dtos;

import com.fawzi.org.bustrips.entities.BusStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BusCreateRequest {
    @NotNull
    private Long plateNumber;

    @Positive
    private Integer busNumber;

    @Positive
    private Integer seatCapacity;

    @NotNull
    private String description;

    @NotNull
    private BusStatus status;
}
