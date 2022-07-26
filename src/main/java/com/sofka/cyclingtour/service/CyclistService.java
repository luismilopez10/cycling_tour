package com.sofka.cyclingtour.service;

import com.sofka.cyclingtour.dto.CyclistDto;
import com.sofka.cyclingtour.entity.Team;

import java.util.List;

public interface CyclistService {

    List<CyclistDto> getAllCyclists();

    Team saveCyclist(CyclistDto cyclistDto);

    CyclistDto updateCyclist(CyclistDto cyclistDto);

    void deleteCyclist(Long id);
}
