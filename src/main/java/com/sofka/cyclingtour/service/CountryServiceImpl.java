package com.sofka.cyclingtour.service;

import com.sofka.cyclingtour.dto.CountryDto;
import com.sofka.cyclingtour.mapper.CountryMapper;
import com.sofka.cyclingtour.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CountryMapper mapper;


    @Override
    public List<CountryDto> getAllCountries() {
        return mapper.countryListToCountryDtoList(countryRepository.findAll());
    }

    @Override
    public CountryDto saveCountry(CountryDto countryDto) {
        return mapper.countryToCountryDto(countryRepository.save(mapper.countryDtoToCountry(countryDto)));
    }

    @Override
    public CountryDto updateCountry(CountryDto countryDto) {
        return mapper.countryToCountryDto(countryRepository.save(mapper.countryDtoToCountry(countryDto)));
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
