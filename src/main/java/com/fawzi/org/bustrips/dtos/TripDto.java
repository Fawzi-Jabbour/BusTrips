package com.fawzi.org.bustrips.dtos;

import com.fawzi.org.bustrips.entities.TripStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class TripDto {
    private Integer id;

    private LocalDateTime departureDate;
    private Integer seatsAvailable;
    private String status;

    private BigDecimal price;

    private LocalDateTime createdAt;

    private Integer busId;
    private Integer originId;
    private String originName;

    private Integer destinationId;
    private String destinationName;


}
