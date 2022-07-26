package com.sofka.cyclingtour.service;

import com.sofka.cyclingtour.dto.CyclistDto;
import com.sofka.cyclingtour.entity.Country;
import com.sofka.cyclingtour.entity.Cyclist;
import com.sofka.cyclingtour.entity.Team;
import com.sofka.cyclingtour.mapper.CyclistMapper;
import com.sofka.cyclingtour.repository.CyclistRepository;
import com.sofka.cyclingtour.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CyclistServiceImpl implements CyclistService{

    @Autowired
    private CyclistRepository cyclistRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CyclistMapper mapper;

    @Override
    public List<CyclistDto> getAllCyclists() {
        return mapper.cyclistListToCyclistDtoList(cyclistRepository.findAll());
    }

    @Override
    public List<CyclistDto> getCyclistsByCountryId(Long countryId) {
        return mapper.cyclistListToCyclistDtoList(cyclistRepository.findByCountryId(countryId));
    }

    @Override
    public List<CyclistDto> getCyclistsByTeamId(Long teamId) {
        return mapper.cyclistListToCyclistDtoList(cyclistRepository.findByTeamId(teamId));
    }

    @Override
    public Team saveCyclist(CyclistDto cyclistDto) {
        Team team = teamRepository.findById(cyclistDto.getTeamId()).get();
        if (team.getCyclistsList().size() < 8) {
            cyclistDto.setCyclistCode(UUID.randomUUID().toString().substring(3,6).toUpperCase());
            team.addCyclist(mapper.cyclistDtoToCyclist(cyclistDto));
        }
        return teamRepository.save(team);
    }

    @Override
    public CyclistDto updateCyclist(CyclistDto cyclistDto) {
        Cyclist cyclist = cyclistRepository.findById(cyclistDto.getId()).get();
        cyclistDto.setCyclistCode(cyclist.getCyclistCode());
        return mapper.cyclistToCyclistDto(cyclistRepository.save(mapper.cyclistDtoToCyclist(cyclistDto)));
    }

    @Override
    public void deleteCyclist(Long id) {
        cyclistRepository.deleteById(id);
    }
}
