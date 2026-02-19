package com.fawzi.org.bustrips.dtos;

import com.fawzi.org.bustrips.entities.BusStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BusUpdateRequest {

    @Positive
    private Integer busNumber;


    private String description;


    private BusStatus status;
}
