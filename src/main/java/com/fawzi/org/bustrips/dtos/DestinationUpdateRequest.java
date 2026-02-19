package com.fawzi.org.bustrips.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DestinationUpdateRequest {
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(min = 2, max = 10)
    private String code;
}
