package com.sofka.cyclingtour.dto;

import lombok.Data;

@Data
public class CyclistDto {
    private Long id;
    private String name;
    private String cyclistCode;
    private Long countryId;
    private Long teamId;
}
