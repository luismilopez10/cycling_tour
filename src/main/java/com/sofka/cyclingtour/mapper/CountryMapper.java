package com.sofka.cyclingtour.mapper;

import com.sofka.cyclingtour.dto.CountryDto;
import com.sofka.cyclingtour.entity.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {
    CountryDto countryToCountryDto(Country country);

    Country countryDtoToCountry(CountryDto countryDto);

    List<CountryDto> countryListToCountryDtoList(List<Country> country);

    List<CountryDto> countryDtoListToCountryList(List<CountryDto> countryDtos);
}
