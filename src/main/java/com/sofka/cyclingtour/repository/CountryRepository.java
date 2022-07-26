package com.sofka.cyclingtour.repository;

import com.sofka.cyclingtour.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
