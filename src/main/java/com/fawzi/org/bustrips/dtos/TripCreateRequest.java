package com.fawzi.org.bustrips.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TripCreateRequest {
    @NotNull
    private LocalDateTime departureDate;

    @NotNull
    @Positive
    private Integer seatsAvailable;

    @NotNull
    private String status;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    @NotNull
    private Integer busId;

    @NotNull
    private Integer originId;

    @NotNull
    private Integer destinationId;
}
