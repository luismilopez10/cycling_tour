package com.sofka.cyclingtour.controller;


import com.sofka.cyclingtour.dto.CyclistDto;
import com.sofka.cyclingtour.entity.Team;
import com.sofka.cyclingtour.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class CyclistController {

    @Autowired
    private CyclistService cyclistService;

    @GetMapping("/cyclists")
    public List<CyclistDto> getAllCyclists() {
        return cyclistService.getAllCyclists();
    }

    @GetMapping("/cyclists/country")
    public List<CyclistDto> getCyclistsByCountry(@RequestParam Long countryId) {
        return cyclistService.getCyclistsByCountryId(countryId);
    }

    @GetMapping("/cyclists/teamid")
    public List<CyclistDto> getCyclistsByTeamId(@RequestParam Long teamId) {
        return cyclistService.getCyclistsByTeamId(teamId);
    }

    @PostMapping("/cyclists")
    public Team saveCyclist(@RequestBody CyclistDto cyclistDto) {
        return cyclistService.saveCyclist(cyclistDto);
    }

    @PutMapping("/cyclists")
    public CyclistDto updateCyclist(@RequestBody CyclistDto cyclistDto) {
        return cyclistService.updateCyclist(cyclistDto);
    }

    @DeleteMapping("/cyclists/{id}")
    public void deleteCyclist(@PathVariable Long id) {
        cyclistService.deleteCyclist(id);
    }
}
