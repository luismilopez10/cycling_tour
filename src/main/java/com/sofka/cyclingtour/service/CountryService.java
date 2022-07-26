package com.sofka.cyclingtour.service;

import com.sofka.cyclingtour.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAllCountries();

    CountryDto saveCountry(CountryDto countryDto);

    CountryDto updateCountry(CountryDto countryDto);

    void deleteCountry(Long id);
}
