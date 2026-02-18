package com.fawzi.org.bustrips.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SeatCreateRequest {

    @NotNull
    @Positive
    private Integer seatNumber;

    @NotNull
    private Integer busId;
}
