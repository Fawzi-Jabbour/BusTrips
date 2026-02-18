package com.fawzi.org.bustrips.dtos;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DestinationDto {
    private Integer id;
    private String name;
    private String code;
    private LocalDateTime createdAt;

}
