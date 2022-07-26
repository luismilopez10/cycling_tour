package com.sofka.cyclingtour.service;

import com.sofka.cyclingtour.dto.CyclistDto;
import com.sofka.cyclingtour.entity.Team;
import com.sofka.cyclingtour.mapper.CyclistMapper;
import com.sofka.cyclingtour.repository.CyclistRepository;
import com.sofka.cyclingtour.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CyclistDto> getCyclistsByCountry(String country) {
        return mapper.cyclistListToCyclistDtoList(cyclistRepository.findByCountry(country));
    }

    @Override
    public List<CyclistDto> getCyclistsByTeamId(Long teamId) {
        return mapper.cyclistListToCyclistDtoList(cyclistRepository.findByTeamId(teamId));
    }

    @Override
    public Team saveCyclist(CyclistDto cyclistDto) {
        Team team = teamRepository.findById(cyclistDto.getTeamId()).get();
        team.addCyclist(mapper.cyclistDtoToCyclist(cyclistDto));
        return teamRepository.save(team);
    }

    @Override
    public CyclistDto updateCyclist(CyclistDto cyclistDto) {
        return mapper.cyclistToCyclistDto(cyclistRepository.save(mapper.cyclistDtoToCyclist(cyclistDto)));
    }

    @Override
    public void deleteCyclist(Long id) {
        cyclistRepository.deleteById(id);
    }
}
