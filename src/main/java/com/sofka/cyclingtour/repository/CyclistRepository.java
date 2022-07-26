package com.sofka.cyclingtour.repository;

import com.sofka.cyclingtour.entity.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist, Long> {
    public List<Cyclist> findByTeamId(Long teamId);
    public List<Cyclist> findByCountry(String country);
}
