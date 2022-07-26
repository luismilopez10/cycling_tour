package com.sofka.cyclingtour.controller;


import com.sofka.cyclingtour.dto.CountryDto;
import com.sofka.cyclingtour.dto.TeamDto;
import com.sofka.cyclingtour.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public List<CountryDto> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping("/countries")
    public CountryDto saveCountry(@RequestBody CountryDto countryDto) {
        return countryService.saveCountry(countryDto);
    }

    @PutMapping("/countries")
    public CountryDto updateCountry(@RequestBody CountryDto countryDto) {
        return countryService.updateCountry(countryDto);
    }

    @DeleteMapping("/countries/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
