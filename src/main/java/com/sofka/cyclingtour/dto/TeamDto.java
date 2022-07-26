package com.sofka.cyclingtour.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TeamDto {
    private Long id;
    private String name;
    private String teamCode;
    private String country;
    private List<CyclistDto> cyclistsList = new ArrayList<>();
}
