package com.sofka.cyclingtour.mapper;

import com.sofka.cyclingtour.dto.CyclistDto;
import com.sofka.cyclingtour.entity.Cyclist;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CyclistMapper {
    CyclistDto cyclistToCyclistDto(Cyclist cyclist);

    Cyclist cyclistDtoToCyclist(CyclistDto cyclistDto);

    List<CyclistDto> cyclistListToCyclistDtoList(List<Cyclist> cyclist);

    List<Cyclist> cyclistDtoListToCyclistList(List<CyclistDto> cyclistDtos);
}
